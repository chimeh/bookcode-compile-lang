package jp.ms.pdf.model;

public class ChapterModel {

	/** 章のタイトル */
	private String title;

	/** 章の階層 */
	private int level;

	/** ページ数 */
	private int pageNum;

	/**
	 * 章のタイトルを取得します。
	 * @return 章のタイトル
	 */
	public String getTitle() {
	    return title;
	}

	/**
	 * 章のタイトルを設定します。
	 * @param titlel 章のタイトル
	 */
	public void setTitle(String title) {
	    this.title = title;
	}

	/**
	 * 章の階層を取得します。
	 * @return 章の階層
	 */
	public int getLevel() {
	    return level;
	}

	/**
	 * 章の階層を設定します。
	 * @param level 章の階層
	 */
	public void setLevel(int level) {
	    this.level = level;
	}

	/**
	 * ページ数を取得します。
	 * @return ページ数
	 */
	public int getPageNum() {
	    return pageNum;
	}

	/**
	 * ページ数を設定します。
	 * @param pageNum ページ数
	 */
	public void setPageNum(int pageNum) {
	    this.pageNum = pageNum;
	}
}
