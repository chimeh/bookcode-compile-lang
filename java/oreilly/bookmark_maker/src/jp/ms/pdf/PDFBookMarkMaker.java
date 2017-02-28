package jp.ms.pdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.ms.pdf.model.ChapterModel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitWidthDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;

public class PDFBookMarkMaker {

	/** 第一階層を表す */
	public static final int LEVEL1 = 1;

	/** 第二階層を表す */
	public static final int LEVEL2 = 2;

	/** 第三階層を表す */
	public static final int LEVEL3 = 3;

	public static void main(String[] args) throws Exception {
		String fileName = args[0];
		String destinationFileName = args[1];
		int startPageNum = Integer.parseInt(args[2]);
		// TODO ファイルが開かれている場合終了する。
		// ファイルを分割する
		List<String> splitFiles = PDFFileOperator.splitPDF(fileName);
		// ファイルを結合する
		PDFFileOperator.mergeTmpPDF(splitFiles, destinationFileName);
		// 最初の50ページから目次のテキストを1行ごとの配列で取得する。
		List<String> lines = PDFFileOperator.getIndexText(splitFiles.get(0));
		PDFBookMarkMaker pdfBookMarkMaker = new PDFBookMarkMaker();
		pdfBookMarkMaker.makeTmpFile(lines);
		List<ChapterModel> chapterList = pdfBookMarkMaker.getChapterModelList(
				lines, startPageNum);
		// TODO AllPagesが一番上の階層になってしまってるのを取り除く
		// TODO 階層構造が仕込めるようにする。
//		pdfBookMarkMaker.createIndex(chapterList, destinationFileName);
		// 作業ファイルを削除する
		PDFFileOperator.deleteTmpPDF(splitFiles);
	}

	/**
	 * 目次情報をPDFに挿入する。
	 * 
	 * @param chapterList
	 *            目次情報の配列
	 * @param destinationFileName
	 *            挿入先のPDFのファイル名
	 * @throws Exception
	 */
	public void createIndex(List<ChapterModel> chapterList,
			String destinationFileName) throws Exception {
		PDDocument document = PDDocument.load(destinationFileName);
		try {
			PDDocumentOutline outline = new PDDocumentOutline();
			document.getDocumentCatalog().setDocumentOutline(outline);
			PDOutlineItem pagesOutline = new PDOutlineItem();
			pagesOutline.setTitle("All Pages");
			outline.appendChild(pagesOutline);
			List pages = document.getDocumentCatalog().getAllPages();
			for (int i = 0; i < pages.size(); i++) {
				for (ChapterModel model : chapterList) {
					if (i == model.getPageNum()) {
						PDPage page = (PDPage) pages.get(i);
						PDPageFitWidthDestination dest = new PDPageFitWidthDestination();
						dest.setPage(page);
						PDOutlineItem bookmark = new PDOutlineItem();
						bookmark.setDestination(dest);
						bookmark.setTitle(model.getTitle());
						pagesOutline.appendChild(bookmark);
					}
				}
			}
			pagesOutline.openNode();
			outline.openNode();

			document.save(destinationFileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

	/**
	 * 目次モデルの配列を取得する。 ページ番号は実際に記述されている内容と差異があるため、渡された開始ページ番号を加算する。
	 * 
	 * @param lines
	 *            行の配列
	 * @param startPageNum
	 *            開始ページ番号
	 * @return 目次モデルの配列
	 */
	public List<ChapterModel> getChapterModelList(List<String> lines,
			int startPageNum) {
		List<ChapterModel> modelList = new ArrayList<ChapterModel>();
		for (String text : lines) {
			ChapterModel model = analyzeChapter(text, startPageNum);
			if (model != null) {
				modelList.add(model);
			}
		}
		return modelList;
	}

	/**
	 * 渡された行が目次情報を持った行かどうか分析する。 ～章で始まる文字列を第一階層のチャプターとして登録 *.*
	 * で始まる文字列を第二階層のチャプターとして登録 *.*.* で始まる文字列を第三階層のチャプターとして登録
	 * ・・・以前の文字列を章のタイトルとする。 ・・・以後の文字列をページ数とする。
	 * テキストを解析し、ChapterModelクラスにそれぞれの情報を格納し返す。
	 * 
	 * @param line
	 *            行
	 * @return 目次モデル
	 */
	public ChapterModel analyzeChapter(String line, int startPageNum) {
		ChapterModel model = null;
		int level = analyzeLevel(line);
		if (level > -1) {
			model = new ChapterModel();
			model.setLevel(level);
			model.setPageNum(getPageNum(line) + startPageNum);
			model.setTitle(getChapterTitle(line));
		}
		return model;
	}

	/**
	 * 渡された行から目次のタイトルを取得する。
	 * 
	 * @param line
	 *            行
	 * @return 目次のタイトル
	 */
	public String getChapterTitle(String line) {
		String title = "";
		if (line.indexOf("･･･") > -1) {
			title = line.substring(0, line.indexOf("･･･") - 1);
		} else {
			title = line.substring(0, line.indexOf("..."));
		}
		return title;
	}

	/**
	 * 渡された行からページ番号を取得する。
	 * 
	 * @param line
	 *            行
	 * @return ページ番号
	 */
	public int getPageNum(String line) {
		int pageNum = -1;
		char[] chars = line.toCharArray();
		int charsLength = chars.length - 1;
		StringBuilder buff = new StringBuilder();
		for (int j = charsLength; j > -1; j--) {
			try {
				char[] tmpChar = { chars[j] };
				String tmpStr = new String(tmpChar);
				Integer tmp = new Integer(tmpStr);
				buff.insert(0, tmp);
			} catch (NumberFormatException e) {
				if (j != charsLength) {
					break;
				}
			}
		}
		if (buff.length() > 0) {
			pageNum = Integer.parseInt(buff.toString());
		}
		return pageNum;
	}

	/**
	 * 目次のタイトルから目次の階層を調べる。 階層
	 * 
	 * @param title
	 *            タイトル
	 * @return 階層をあらわす数字
	 */
	public int analyzeLevel(String title) {
		String reg_level1_num = "[0-9].*章.*･･･.*[0-9]";
		String reg_level1_num_dot = "[0-9].*章.*\\.\\.\\..*[0-9]";
		String reg_level1_appendix = "付録.*･･･.*[0-9]";
		String reg_level1_appendix_dot = "付録.*\\.\\.\\..*[0-9]";
		String reg_level2 = "[0-Z]\\...* .*･･･.*[0-9]";
		String reg_level2_dot = "[0-Z]\\...* .*\\.\\.\\..*[0-9]";
		String reg_level3 = "[0-Z]\\.[0-z]\\..*･･･.*[0-9]";
		String reg_level3_dot = "[0-Z]\\.[0-z]\\..*\\.\\.\\..*[0-9]";

		String[] level1 = { reg_level1_num, reg_level1_num_dot,
				reg_level1_appendix, reg_level1_appendix_dot };
		String[] level2 = { reg_level2, reg_level2_dot };
		String[] level3 = { reg_level3, reg_level3_dot };
		if (matcher(level1, title)) {
			return LEVEL1;
		}
		if (matcher(level2, title)) {
			if (matcher(level3, title)) {
				return LEVEL3;
			} else {
				return LEVEL2;
			}
		}
		return -1;
	}

	/**
	 * 渡された正規表現文字列と対象文字列を比較する。
	 * 
	 * @param regex
	 *            正規表現文字列
	 * @param target
	 *            対象の文字列
	 * @return 正規表現に合致した場合はtrue、そうでなければfalse
	 */
	private boolean matcher(String[] regexs, String target) {
		boolean match = false;
		for (String regex : regexs) {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(target);
			if (m.find()) {
				match = true;
				break;
			}
		}
		return match;
	}

	private void makeTmpFile(List<String> lines) {

		try {
			File file = new File("/Users/masashouji/Desktop/lines.txt");

			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
					file)));
			for (String tmp : lines) {
				pw.println(tmp);
			}

			pw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
