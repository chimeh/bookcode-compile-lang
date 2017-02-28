package io;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;

public class FileLister extends Frame implements ActionListener, ItemListener {
    private List list;
    private TextField details;
    private Panel buttons;
    private Button up, close;
    private File currentDir;
    private FilenameFilter filter;
    private String[] files;
    private DateFormat dateFormatter =
            DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

    public FileLister(String directory, FilenameFilter filter) {
        super("File Lister");
        this.filter = filter;

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { dispose(); }
        });

        list = new List(12, false);
        list.setFont(new Font("MonoSpaced", Font.PLAIN, 14));
        list.addActionListener(this);
        list.addItemListener(this);

        details = new TextField();
        details.setFont(new Font("MonoSpaced", Font.PLAIN, 12));
        details.setEditable(false);

        buttons = new Panel();
        buttons.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 5));
        buttons.setFont(new Font("SansSerif", Font.BOLD, 14));

        up = new Button("Up a Directory");
        up.addActionListener(this);

        close = new Button("Close");
        close.addActionListener(this);

        buttons.add(up);
        buttons.add(close);

        this.add(list, "Center");
        this.add(details, "North");
        this.add(buttons, "South");
        this.setSize(500, 350);

        listDirectory(directory);
    }

    public void listDirectory(String directory) {
        File dir = new File(directory);
        if (!dir.isDirectory())
            throw new IllegalArgumentException("FileLister: no such directory");

        files = dir.list(filter);

        java.util.Arrays.sort(files);

        list.removeAll();
        list.add("[Up to Parent Directory]");
        for (int i = 0; i < files.length; i++) list.add(files[i]);

        this.setTitle(directory);
        details.setText(directory);

        currentDir = dir;
    }

    public void itemStateChanged(ItemEvent e) {
        int i = list.getSelectedIndex() - 1;
        if (i < 0) return;
        String filename = files[i];
        File f = new File(currentDir, filename);
        if (!f.exists())
            throw new IllegalArgumentException("FileLister: " + "no such file or directory");

        String info = filename;
        if (f.isDirectory()) info += File.separator;
        info += " " + f.length() + " bytes ";
        info += dateFormatter.format(new java.util.Date(f.lastModified()));
        if (f.canRead()) info += " Read";
        if (f.canWrite()) info += "Write";

        details.setText(info);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == close) this.dispose();
        else if (e.getSource() == up) { up(); }
        else if (e.getSource() == list) {
            int i = list.getSelectedIndex();
            if (i == 0) up();
            else {
                String name = files[i-1];
                File f = new File(currentDir, name);
                String fullname = f.getAbsolutePath();
                if (f.isDirectory()) listDirectory(fullname);
                else new FileViewer(fullname).show();
            }
        }
    }

    protected void up() {
        String parent = currentDir.getParent();
        if (parent == null) return;
        listDirectory(parent);
    }

    public static void usage() {
        System.out.println("Usage: java FileLister [directory_name] " +
                            "[-e file_extension]");
        System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        FileLister f;
        FilenameFilter filter = null;
        String directory = null;

        for (int i = 0; i < args.length; i ++) {
            if (args[i].equals("-e")) {
                if (++i >= args.length) usage();
                final String suffix = args[i];

                filter = new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        if (name.endsWith(suffix)) return true;
                        else return (new File(dir, name)).isDirectory();
                    }
                };
            }
            else {
                if (directory != null) usage();
                else directory = args[i];
            }
        }

        if (directory == null) directory = System.getProperty("user.dir");
        f = new FileLister(directory, filter);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) { System.exit(0); }
        });
        f.show();
    }

}
