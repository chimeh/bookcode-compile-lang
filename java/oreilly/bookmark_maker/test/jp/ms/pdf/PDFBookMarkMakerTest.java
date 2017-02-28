package jp.ms.pdf;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import jp.ms.pdf.model.ChapterModel;

import org.junit.Test;

public class PDFBookMarkMakerTest {

	@Test
	public void analyzeChapterTest() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String sentence = "1章　Emacs入門 ･････････････････････････････････････････････････････････････････････････････････････････････････ 1";
		ChapterModel testCase = new ChapterModel();
		testCase.setLevel(1);
		testCase.setPageNum(1);
		testCase.setTitle("1章　Emacs入門");
		ChapterModel model = pdf.analyzeChapter(sentence, 0);
		assertThat(model.getTitle(), is(testCase.getTitle()));
		assertThat(model.getLevel(), is(testCase.getLevel()));
		assertThat(model.getPageNum(), is(testCase.getPageNum()));
	}

	@Test
	public void analyzeChapterTest_null() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String sentence = "入門GNU Emacs";
		ChapterModel model = pdf.analyzeChapter(sentence, 0);
		assertThat(model, is(nullValue()));
	}



	@Test
	public void analyzeLevelTest_level1() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "1章　Emacs入門 ･････････････････････････････････････････････････････････････････････････････････････････････････ 1";
		int level = pdf.analyzeLevel(title);
		assertThat(level, is(1));
	}

	@Test
	public void analyzeLevelTest_level1_dot() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "1章　bashの基礎 ...................................................................................... 1";
		int level = pdf.analyzeLevel(title);
		assertThat(level, is(1));
	}

	@Test
	public void analyzeLevelTest_level1_appendix() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "付録A 関連シェル･････････････････････････････････････････････････････････････295";
		int level = pdf.analyzeLevel(title);
		assertThat(level, is(1));
	}

	@Test
	public void analyzeLevelTest_level1_appendix_dot() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "付録A 関連シェル................................................................................. 295";
		int level = pdf.analyzeLevel(title);
		assertThat(level, is(1));
	}

	@Test
	public void analyzeLevelTest_level2() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "1.1 Emacsへようこそ！ ････････････････････････････････････････････････････････････････････････････････････ 1";
		assertThat(pdf.analyzeLevel(title), is(2));
	}

	@Test
	public void analyzeLevelTest_level2_dot() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "1.1 シェルとは何か ........................................................................................................................................................... 2";
		assertThat(pdf.analyzeLevel(title), is(2));
	}

	@Test
	public void analyzeLevelTest_level2_appendix() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "A.1 Bourne シェル ････････････････････････････････････････････････････････････････････････････････････  296";
		assertThat(pdf.analyzeLevel(title), is(2));
	}

	@Test
	public void analyzeLevelTest_level2_appendix_dot() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "A.1 Bourne シェル ...................................................................................................................................................... 296";
		assertThat(pdf.analyzeLevel(title), is(2));
	}

	@Test
	public void analyzeLevelTest_level3() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "1.7.1 間違ったファイルを開いたら ･･････････････････････････････････････････････････････････････ 11";
		assertThat(pdf.analyzeLevel(title), is(3));
	}

	@Test
	public void analyzeLevelTest_level3_dot() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "1.3.1 bash ................................................................................................................................................................... 4";
		assertThat(pdf.analyzeLevel(title), is(3));
	}

	@Test
	public void analyzeLevelTest_level3_appendix() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "A.6.1 Cygwin ･････････････････････････････････････････････････････ 304";
		assertThat(pdf.analyzeLevel(title), is(3));
	}

	@Test
	public void analyzeLevelTest_level3_appendix_dot() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "A.6.1 Cygwin ..................................................................................................................................................... 304";
		assertThat(pdf.analyzeLevel(title), is(3));
	}

	@Test
	public void analyzeLevelTest_wrong_case_1() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "プログラム単位 ･････････････････････････････････････････････････････ 320";
		assertThat(pdf.analyzeLevel(title), is(-1));
	}

	@Test
	public void analyzeLevelTest_wrong_case_2() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "C-x 4. ･････････････････････････････････････････････････････････････････ 249";
		assertThat(pdf.analyzeLevel(title), is(-1));
	}

	@Test
	public void analyzeLevelTest_wrong_case_3() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "プログラム可能な補完.................................................. 289, 333-336";
		assertThat(pdf.analyzeLevel(title), is(-1));
	}

	@Test
	public void analyzeLevelTest_blank() {
		PDFBookMarkMaker pdf = new PDFBookMarkMaker();
		String title = "プログラム単位 ･････････････････････････････････････････････････････ 320";
		assertThat(pdf.analyzeLevel(title), is(-1));
	}

}
