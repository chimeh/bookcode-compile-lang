/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewNewJFrame.java
 *
 * Created on 2011/04/17, 14:14:16
 */

package jp.ms.GUI;

import java.awt.Container;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import jp.ms.pdf.PDFBookMarkMaker;

/**
 * 
 * @author mshoj
 */
public class AppFrame extends javax.swing.JFrame {

	/** Creates new form NewNewJFrame */
	public AppFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jDialog1 = new javax.swing.JDialog();
		jDialog2 = new javax.swing.JDialog();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jProgressBar1 = new javax.swing.JProgressBar();

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(
				jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(
				jDialog2.getContentPane());
		jDialog2.getContentPane().setLayout(jDialog2Layout);
		jDialog2Layout.setHorizontalGroup(jDialog2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jDialog2Layout.setVerticalGroup(jDialog2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("対象ファイル");

		jLabel2.setText("開始ページ数");

		jLabel3.setText("出力ファイル名");

		jButton1.setText("ファイルを選択");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}
		});

		jButton2.setText("目次挿入開始");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jProgressBar1,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														611, Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		80,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGap(305,
																		305,
																		305)
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		138,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						jLabel3,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						80,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel1,
																						javax.swing.GroupLayout.Alignment.LEADING,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						80,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jTextField2,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						409,
																						Short.MAX_VALUE)
																				.addComponent(
																						jTextField1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						409,
																						Short.MAX_VALUE)
																				.addComponent(
																						jTextField3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						83,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18,
																		18)
																.addComponent(
																		jButton1))
												.addComponent(
														jLabel4,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														611, Short.MAX_VALUE))
								.addGap(29, 29, 29)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(25, 25, 25)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														26,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														24,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														22,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jLabel3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														26,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														22,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														jButton2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		jLabel2,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		26,
																		Short.MAX_VALUE)
																.addComponent(
																		jTextField3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		22,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18)
								.addComponent(jProgressBar1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel4,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										37, Short.MAX_VALUE).addGap(47, 47, 47)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
		JFileChooser filechooser = new JFileChooser();

		int selected = filechooser.showOpenDialog(this);
		if (selected == JFileChooser.APPROVE_OPTION) {
			File file = filechooser.getSelectedFile();
			jTextField1.setText(file.getAbsolutePath());
			int last = file.getAbsolutePath().lastIndexOf(file.getName());
			String dirName = file.getAbsolutePath().substring(0, last);
			String newFileName = dirName
					+ file.getName().substring(0, file.getName().length() - 4)
					+ "-new" + ".pdf";
			jTextField2.setText(newFileName);
		}
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField3ActionPerformed

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO バリデーション実装→この方法では上手くバリデーションが動いてない
		if (jTextField1.getText().isEmpty()) {
			jLabel4.setText("ファイルを選択してください。");
		}
		// TODO ファイルパス整合性チェック
		try {
			Integer.parseInt(jTextField3.getText());
			jLabel4.setText("");
		} catch (NumberFormatException e) {
			jLabel4.setText("開始ページ数には数字を入力してください。");
			return;
		}

		File file = new File(jTextField2.getText());
		if (file.exists()) {
			Container c = getContentPane();
			int ans = JOptionPane.showConfirmDialog(c,
					"ファイルはすでに存在しています。上書きしていいですか？", "CAUTION!",
					JOptionPane.OK_CANCEL_OPTION);
			if (ans == JOptionPane.CANCEL_OPTION) {
				return;
			}
		}
		jLabel4.setText("目次挿入中・・・");
		final String[] args = { jTextField1.getText(), jTextField2.getText(),
				jTextField3.getText() };
		jButton1.setEnabled(false);
		jButton2.setEnabled(false);
		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);

		// TODO プログレスバーの実装 jButton1.setEnabled(false);
		jButton2.setEnabled(false);
		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jProgressBar1.setIndeterminate(true);
		worker = new SwingWorker<String, String>() {

			@Override
			public String doInBackground() {
				try {
					PDFBookMarkMaker.main(args);
				} catch (Exception e) {
				}
				return "Done";
			}

			@Override
			protected void process(java.util.List<String> chunks) {
				for (String message : chunks) {
					appendLine(message);
				}
			}

			@Override
			public void done() { // assert
				EventQueue.isDispatchThread();
				jButton1.setEnabled(true);
				jButton2.setEnabled(true);
				jTextField1.setEditable(true);
				jTextField2.setEditable(true);
				jTextField3.setEditable(true);
				appendLine("目次挿入が終了しました。");
				String text = null;
				if (isCancelled()) {
					text = "Cancelled";
				} else {
					try {
						text = get();
					} catch (Exception ex) {
						ex.printStackTrace();
						text = "Exception";
					}
				}
			}
		};
		worker.addPropertyChangeListener(new ProgressListener(jProgressBar1));
		worker.execute();
		jProgressBar1.setIndeterminate(false);

	}// GEN-LAST:event_jButton2ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AppFrame().setVisible(true);
			}
		});
	}

	class ProgressListener implements PropertyChangeListener {
		private final JProgressBar progressBar;

		ProgressListener(JProgressBar progressBar) {
			this.progressBar = progressBar;
			this.progressBar.setValue(0);
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			String strPropertyName = evt.getPropertyName();
			if ("progress".equals(strPropertyName)) {
				progressBar.setIndeterminate(false);
				int progress = (Integer) evt.getNewValue();
				progressBar.setValue(progress);
			}
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JDialog jDialog2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private SwingWorker<String, String> worker;

	// End of variables declaration//GEN-END:variables

	private void appendLine(String str) {
		jLabel4.setText(str);
	}

}
