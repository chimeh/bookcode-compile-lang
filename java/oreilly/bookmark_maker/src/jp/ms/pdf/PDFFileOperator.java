package jp.ms.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.PDFMerger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PDFFileOperator {

	// PDFファイルを指定されたフォルダの「__tmp__」フォルダ以下に50ページごとに分割する
	// 「__tmp__」フォルダが見つかった場合作業中止
	// 分割してできたファイル名の配列を返す
	public static List<String> splitPDF(String fileName) throws Exception {
		PDFSplitCustom split = new PDFSplitCustom();
		return split.split(fileName);
	}

	// 分割されたファイルを結合する
	public static void mergeTmpPDF(List<String> splitFiles, String fileName)
			throws Exception {
		List<String> tmpFileList = new ArrayList<String>();
		tmpFileList.addAll(splitFiles);
		tmpFileList.add(fileName);
		int size = tmpFileList.size();
		String[] fileNames = new String[size];
		for (int i = 0; i < size; i++) {
			fileNames[i] = tmpFileList.get(i);
		}
		PDFMerger.main(fileNames);
	}

	// 分割してできたファイルを削除する
	public static void deleteTmpPDF(List<String> fileNames) throws Exception {
		String dirName = PDFSplitCustom.getDirName(new File(fileNames.get(0)));
		for (String fileName : fileNames) {
			File file = new File(fileName);
			if (!file.delete()) {
				throw new Exception(
						"作業ファイル削除中にエラーが発生しました。お手数ですが手動で「__tmp__」ディレクトリを削除してください。");
			}
		}
		File file = new File(dirName);
		file.delete();
	}

	// 最初の50ページのPDFファイルをテキスト化し、文字列で返す
	public static List<String> getIndexText(String fileName) throws Exception{
		String textInPDF = "";
		List<String> lines = new ArrayList<String>();
		try {
			File file = new File(fileName);
			PDDocument document = null;
			try {
				document = PDDocument.load(file);
				PDFTextStripper textStripper = new PDFTextStripper();
				document.getDocumentCatalog().getDocumentOutline();
				textInPDF = textStripper.getText(document);
				String[] tmpLines = textInPDF.split("\n");
				int size = tmpLines.length;
				for(int i = 0; i < size; i++){
					lines.add(tmpLines[i]);
				}

			} catch (IOException e) {
			} finally {
				document.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルが見つかりませんでした。");
		}
		return lines;
	}

}
