package org.open2jam.gui;


/*
 * Interface.java
 *
 * Created on Oct 30, 2010, 6:51:02 PM
 */

import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import org.open2jam.parser.Chart;
import org.open2jam.render.Render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.open2jam.parser.ChartList;
/**
 *
 * @author fox
 */
public class NewInterface extends javax.swing.JFrame
        implements PropertyChangeListener, ListSelectionListener {

    static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private ChartTableModel model_songlist;
    private String cwd;
    private DisplayMode[] display_modes;
    private ChartModelLoader task;
    private int rank = 0;
    private Chart selected_header;
    private int last_model_idx;
    private final TableRowSorter table_sorter;

    /** Creates new form Interface */
    public NewInterface() {
        initLogic();
        initComponents();
        this.setLocationRelativeTo(null);
        load_progress.setVisible(false);
        table_sorter = (TableRowSorter) table_songlist.getRowSorter();
        txt_filter.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {updateFilter();}
            public void removeUpdate(DocumentEvent e) {updateFilter();}
            public void changedUpdate(DocumentEvent e) {updateFilter();}
        });

        javax.swing.table.TableColumn col = null;
        col = table_songlist.getColumnModel().getColumn(0);
        col.setPreferredWidth(180);
        col = table_songlist.getColumnModel().getColumn(1);
        col.setPreferredWidth(30);
        col = table_songlist.getColumnModel().getColumn(2);
        col.setPreferredWidth(80);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rank_group = new javax.swing.ButtonGroup();
        panel_info = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        lbl_artist = new javax.swing.JLabel();
        lbl_bpm = new javax.swing.JLabel();
        lbl_level = new javax.swing.JLabel();
        lbl_notes = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        lbl_genre = new javax.swing.JLabel();
        lbl_bpm1 = new javax.swing.JLabel();
        lbl_genre1 = new javax.swing.JLabel();
        lbl_level1 = new javax.swing.JLabel();
        lbl_notes1 = new javax.swing.JLabel();
        lbl_time1 = new javax.swing.JLabel();
        bt_play = new javax.swing.JButton();
        lbl_cover = new javax.swing.JLabel();
        lbl_keys1 = new javax.swing.JLabel();
        lbl_keys = new javax.swing.JLabel();
        jc_autoplay = new javax.swing.JCheckBox();
        combo_channelModifier = new javax.swing.JComboBox();
        lbl_channelModifier = new javax.swing.JLabel();
        combo_visibilityModifier = new javax.swing.JComboBox();
        lbl_visibilityModifier = new javax.swing.JLabel();
        lbl_filename = new javax.swing.JLabel();
        table_scroll2 = new javax.swing.JScrollPane();
        table_songlist2 = new javax.swing.JTable();
        panel_setting = new javax.swing.JPanel();
        jr_rank_hard = new javax.swing.JRadioButton();
        combo_displays = new javax.swing.JComboBox();
        txt_res_height = new javax.swing.JTextField();
        txt_res_width = new javax.swing.JTextField();
        jc_vsync = new javax.swing.JCheckBox();
        lbl_rank = new javax.swing.JLabel();
        lbl_display = new javax.swing.JLabel();
        jc_custom_size = new javax.swing.JCheckBox();
        jr_rank_easy = new javax.swing.JRadioButton();
        lbl_hispeed = new javax.swing.JLabel();
        lbl_res_x = new javax.swing.JLabel();
        jr_rank_normal = new javax.swing.JRadioButton();
        jc_full_screen = new javax.swing.JCheckBox();
        bt_choose_dir = new javax.swing.JButton();
        load_progress = new javax.swing.JProgressBar();
        js_hispeed = new javax.swing.JSpinner();
        configuration = new javax.swing.JButton();
        table_scroll = new javax.swing.JScrollPane();
        table_songlist = new javax.swing.JTable();
        txt_filter = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitem_exit = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menu_about = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Open2Jam");

        lbl_title.setFont(new java.awt.Font("Tahoma", 0, 18));
        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Title");

        lbl_artist.setFont(new java.awt.Font("Tahoma", 2, 11));
        lbl_artist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_artist.setText("Artist");

        lbl_bpm.setText("content");

        lbl_level.setText("content");

        lbl_notes.setText("content");

        lbl_time.setText("content");

        lbl_genre.setText("content");

        lbl_bpm1.setText("BPM:");

        lbl_genre1.setText("Genre:");

        lbl_level1.setText("Level:");

        lbl_notes1.setText("Notes:");

        lbl_time1.setText("Time:");

        bt_play.setFont(new java.awt.Font("Tahoma", 0, 18));
        bt_play.setText("Play !");
        bt_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_playActionPerformed(evt);
            }
        });

        lbl_cover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_cover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_cover.setIconTextGap(0);
        lbl_cover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_coverMouseClicked(evt);
            }
        });

        lbl_keys1.setText("Keys:");

        lbl_keys.setText("content");

        jc_autoplay.setText("Autoplay");

        combo_channelModifier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--None--", "Mirror", "Shuffle", "Random" }));

        lbl_channelModifier.setText("Channel Modifier:");

        combo_visibilityModifier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--None--", "Hidden", "Sudden", "Dark" }));

        lbl_visibilityModifier.setText("Visibility Modifier:");

        lbl_filename.setFont(new java.awt.Font("Tahoma", 0, 10));
        lbl_filename.setText("filename");

        table_songlist2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_scroll2.setViewportView(table_songlist2);

        javax.swing.GroupLayout panel_infoLayout = new javax.swing.GroupLayout(panel_info);
        panel_info.setLayout(panel_infoLayout);
        panel_infoLayout.setHorizontalGroup(
            panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_infoLayout.createSequentialGroup()
                .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_infoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jc_autoplay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_play))
                    .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_title, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addGroup(panel_infoLayout.createSequentialGroup()
                            .addComponent(lbl_cover, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panel_infoLayout.createSequentialGroup()
                                    .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_bpm1)
                                        .addComponent(lbl_genre1)
                                        .addComponent(lbl_level1)
                                        .addComponent(lbl_notes1)
                                        .addComponent(lbl_time1)
                                        .addComponent(lbl_keys1))
                                    .addGap(18, 18, 18)
                                    .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_keys)
                                        .addComponent(lbl_level, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(lbl_notes, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(lbl_time, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(lbl_genre, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(lbl_bpm, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                                .addComponent(lbl_filename)))
                        .addComponent(lbl_artist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addComponent(table_scroll2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                        .addGroup(panel_infoLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbl_channelModifier)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(combo_channelModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(lbl_visibilityModifier)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                            .addComponent(combo_visibilityModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panel_infoLayout.setVerticalGroup(
            panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_infoLayout.createSequentialGroup()
                .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_cover, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_infoLayout.createSequentialGroup()
                        .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_bpm1)
                            .addComponent(lbl_bpm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_genre)
                            .addComponent(lbl_genre1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_level)
                            .addComponent(lbl_level1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_notes1)
                            .addComponent(lbl_notes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_time)
                            .addComponent(lbl_time1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_keys1)
                            .addComponent(lbl_keys))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_filename)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_artist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table_scroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_channelModifier)
                    .addComponent(combo_channelModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_visibilityModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_visibilityModifier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(panel_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jc_autoplay)
                    .addComponent(bt_play)))
        );

        rank_group.add(jr_rank_hard);
        jr_rank_hard.setText("Hard");
        jr_rank_hard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jr_rank_hard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jr_rank_hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_rank_hardActionPerformed(evt);
            }
        });

        combo_displays.setModel(new javax.swing.DefaultComboBoxModel(display_modes));

        txt_res_height.setText("600");
        txt_res_height.setEnabled(false);

        txt_res_width.setText("800");
        txt_res_width.setEnabled(false);

        jc_vsync.setSelected(true);
        jc_vsync.setText("Use VSync");

        lbl_rank.setText("Rank:");

        lbl_display.setText("Display:");

        jc_custom_size.setText("custom size:");
        jc_custom_size.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                custom_size_clicked(evt);
            }
        });

        rank_group.add(jr_rank_easy);
        jr_rank_easy.setSelected(true);
        jr_rank_easy.setText("Easy");
        jr_rank_easy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jr_rank_easy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jr_rank_easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_rank_easyActionPerformed(evt);
            }
        });

        lbl_hispeed.setText("Hi-Speed:");

        lbl_res_x.setText("x");

        rank_group.add(jr_rank_normal);
        jr_rank_normal.setText("Normal");
        jr_rank_normal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jr_rank_normal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jr_rank_normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_rank_normalActionPerformed(evt);
            }
        });

        jc_full_screen.setText("Full screen");

        bt_choose_dir.setText("Choose dir");
        bt_choose_dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_choose_dirActionPerformed(evt);
            }
        });

        load_progress.setStringPainted(true);

        js_hispeed.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.5d, 10.0d, 0.5d));

        configuration.setText("Configuration");
        configuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configurationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_settingLayout = new javax.swing.GroupLayout(panel_setting);
        panel_setting.setLayout(panel_settingLayout);
        panel_settingLayout.setHorizontalGroup(
            panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_settingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_settingLayout.createSequentialGroup()
                        .addComponent(jr_rank_easy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jr_rank_normal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jr_rank_hard))
                    .addComponent(lbl_rank)
                    .addGroup(panel_settingLayout.createSequentialGroup()
                        .addComponent(lbl_hispeed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(js_hispeed, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addGap(72, 72, 72))
                    .addGroup(panel_settingLayout.createSequentialGroup()
                        .addComponent(configuration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_display)
                    .addGroup(panel_settingLayout.createSequentialGroup()
                        .addComponent(jc_vsync)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jc_full_screen))
                    .addGroup(panel_settingLayout.createSequentialGroup()
                        .addComponent(jc_custom_size, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_res_width, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_res_x)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_res_height, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combo_displays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_settingLayout.createSequentialGroup()
                        .addComponent(bt_choose_dir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(load_progress, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        panel_settingLayout.setVerticalGroup(
            panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_settingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(load_progress, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(bt_choose_dir))
                .addGap(18, 18, 18)
                .addComponent(lbl_rank)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jr_rank_easy)
                    .addComponent(jr_rank_normal)
                    .addComponent(jr_rank_hard))
                .addGap(22, 22, 22)
                .addGroup(panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(js_hispeed, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_hispeed))
                .addGap(18, 18, 18)
                .addComponent(lbl_display)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_displays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_res_width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_res_height, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_res_x)
                    .addComponent(jc_custom_size))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jc_vsync)
                    .addComponent(jc_full_screen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(configuration)
                .addGap(112, 112, 112))
        );

        table_songlist.setAutoCreateRowSorter(true);
        table_songlist.setModel(model_songlist);
        table_songlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_songlist.getSelectionModel().addListSelectionListener(this);
        table_scroll.setViewportView(table_songlist);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Source");

        jMenu1.setText("File");

        mitem_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mitem_exit.setText("Exit");
        mitem_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitem_exitActionPerformed(evt);
            }
        });
        jMenu1.add(mitem_exit);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Tools");

        jMenuItem1.setText("OJM Dumper");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("OJN <-> BMS");
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        menu_about.setText("About");
        menu_about.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu_about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_aboutMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_about);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(panel_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_filter, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(table_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_info, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(table_scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel_setting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custom_size_clicked(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_custom_size_clicked

        if (evt.getStateChange() == ItemEvent.SELECTED){
            combo_displays.setEnabled(false);
            txt_res_width.setEnabled(true);
            lbl_res_x.setEnabled(true);
            txt_res_height.setEnabled(true);
        }else{
            txt_res_width.setEnabled(false);
            lbl_res_x.setEnabled(false);
            txt_res_height.setEnabled(false);
            combo_displays.setEnabled(true);
        }
    }//GEN-LAST:event_custom_size_clicked

    private void bt_choose_dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_choose_dirActionPerformed

        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(cwd));
        jfc.setDialogTitle("Choose a directory");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.setAcceptAllFileFilterUsed(false);
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            cwd = jfc.getSelectedFile().getAbsolutePath();
            updateSelection();
        }
    }//GEN-LAST:event_bt_choose_dirActionPerformed

    private void lbl_coverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_coverMouseClicked

        JOptionPane.showMessageDialog(this, null, "Cover",
                JOptionPane.INFORMATION_MESSAGE, new ImageIcon(selected_header.getCover()));
    }//GEN-LAST:event_lbl_coverMouseClicked

    private void jr_rank_normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_rank_normalActionPerformed

        rank = 1;
        int sel_row = table_songlist.getSelectedRow();
        if(sel_row >= 0)last_model_idx = table_songlist.convertRowIndexToModel(sel_row);
        model_songlist.setRank(rank);
    }//GEN-LAST:event_jr_rank_normalActionPerformed

    private void jr_rank_easyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_rank_easyActionPerformed

        rank = 0;
        int sel_row = table_songlist.getSelectedRow();
        if(sel_row >= 0)last_model_idx = table_songlist.convertRowIndexToModel(sel_row);
        model_songlist.setRank(rank);
    }//GEN-LAST:event_jr_rank_easyActionPerformed

    private void jr_rank_hardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_rank_hardActionPerformed

        rank = 2;
        int sel_row = table_songlist.getSelectedRow();
        if(sel_row >= 0)last_model_idx = table_songlist.convertRowIndexToModel(sel_row);
        model_songlist.setRank(rank);
    }//GEN-LAST:event_jr_rank_hardActionPerformed

    private void bt_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_playActionPerformed

        if(selected_header != null)
	{
	    final double hispeed = (Double) js_hispeed.getValue();

	    final DisplayMode dm;
	    if(jc_custom_size.isSelected()){ // custom size selected
		int w,h;
		try{
		    w = Integer.parseInt(txt_res_width.getText());
		    h = Integer.parseInt(txt_res_height.getText());
		}catch(Exception e){
		    JOptionPane.showMessageDialog(this, "Invalid value on custom size", "Error", JOptionPane.WARNING_MESSAGE);
		    return;
		}
		dm = new DisplayMode(w,h);
	    }else{
		dm = (DisplayMode) combo_displays.getSelectedItem();
	    }
	    final boolean vsync = jc_vsync.isSelected();
	    final boolean fs = jc_full_screen.isSelected();

	    final boolean autoplay = jc_autoplay.isSelected();

	    final int channelModifier = combo_channelModifier.getSelectedIndex();

	    Render r = new Render(selected_header, hispeed, autoplay, channelModifier);

	    r.setDisplay(dm, vsync, fs);

	    r.startRendering();
	}
    }//GEN-LAST:event_bt_playActionPerformed

    private void configurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configurationActionPerformed
	new Configuration().setVisible(true);
    }//GEN-LAST:event_configurationActionPerformed

    private void mitem_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitem_exitActionPerformed
        System.exit(0); //TODO Not a good idea XD
    }//GEN-LAST:event_mitem_exitActionPerformed

    private void menu_aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_aboutMouseClicked
        String about = "Open2Jam\n"
                + "Main programmer: ChaosFox\n"
                + "Main code destroyer: CdK"    ;
        JOptionPane.showMessageDialog(this, about, "About", JOptionPane.ERROR_MESSAGE, null);
    }//GEN-LAST:event_menu_aboutMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_choose_dir;
    private javax.swing.JButton bt_play;
    private javax.swing.JComboBox combo_channelModifier;
    private javax.swing.JComboBox combo_displays;
    private javax.swing.JComboBox combo_visibilityModifier;
    private javax.swing.JButton configuration;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JCheckBox jc_autoplay;
    private javax.swing.JCheckBox jc_custom_size;
    private javax.swing.JCheckBox jc_full_screen;
    private javax.swing.JCheckBox jc_vsync;
    private javax.swing.JRadioButton jr_rank_easy;
    private javax.swing.JRadioButton jr_rank_hard;
    private javax.swing.JRadioButton jr_rank_normal;
    private javax.swing.JSpinner js_hispeed;
    private javax.swing.JLabel lbl_artist;
    private javax.swing.JLabel lbl_bpm;
    private javax.swing.JLabel lbl_bpm1;
    private javax.swing.JLabel lbl_channelModifier;
    private javax.swing.JLabel lbl_cover;
    private javax.swing.JLabel lbl_display;
    private javax.swing.JLabel lbl_filename;
    private javax.swing.JLabel lbl_genre;
    private javax.swing.JLabel lbl_genre1;
    private javax.swing.JLabel lbl_hispeed;
    private javax.swing.JLabel lbl_keys;
    private javax.swing.JLabel lbl_keys1;
    private javax.swing.JLabel lbl_level;
    private javax.swing.JLabel lbl_level1;
    private javax.swing.JLabel lbl_notes;
    private javax.swing.JLabel lbl_notes1;
    private javax.swing.JLabel lbl_rank;
    private javax.swing.JLabel lbl_res_x;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JLabel lbl_time1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_visibilityModifier;
    private javax.swing.JProgressBar load_progress;
    private javax.swing.JMenu menu_about;
    private javax.swing.JMenuItem mitem_exit;
    private javax.swing.JPanel panel_info;
    private javax.swing.JPanel panel_setting;
    private javax.swing.ButtonGroup rank_group;
    private javax.swing.JScrollPane table_scroll;
    private javax.swing.JScrollPane table_scroll2;
    private javax.swing.JTable table_songlist;
    private javax.swing.JTable table_songlist2;
    private javax.swing.JTextField txt_filter;
    private javax.swing.JTextField txt_res_height;
    private javax.swing.JTextField txt_res_width;
    // End of variables declaration//GEN-END:variables

    private void initLogic() {
        cwd = System.getProperty("user.dir");
        try {
            display_modes = Display.getAvailableDisplayModes();
        } catch (LWJGLException ex) {
            logger.log(Level.WARNING, "Could not get the display modes !! {0}", ex.getMessage());
        }
        model_songlist = new ChartTableModel();
    }

    private void updateSelection() {
        this.setTitle("Open2Jam - "+cwd);
        bt_choose_dir.setEnabled(false);
        load_progress.setValue(0);
        load_progress.setVisible(true);
        task = new ChartModelLoader(model_songlist, new File(cwd));
        task.addPropertyChangeListener(this);
        task.execute();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if("progress".equals(evt.getPropertyName()))
        {
            int i = (Integer) evt.getNewValue();
            load_progress.setValue(i);
            if(i == 100)
            {
                bt_choose_dir.setEnabled(true);
                load_progress.setVisible(false);
            }
        }
    }

    public void updateFilter() {
        try {
            if(txt_filter.getText().length() == 0)table_sorter.setRowFilter(null);
            else table_sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txt_filter.getText()));
        } catch (java.util.regex.PatternSyntaxException ex) {
            return;
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        int i = table_songlist.getSelectedRow();
        if(i < 0 && last_model_idx >= 0){
            i = last_model_idx;
            int i_view = table_songlist.convertRowIndexToView(i);
            table_songlist.getSelectionModel().setSelectionInterval(0, i_view);
            table_scroll.getVerticalScrollBar().setValue(table_songlist.getCellRect(i_view, 0, false).y);
        }else{
            i = table_songlist.convertRowIndexToModel(i);
        }
        ChartList cl = model_songlist.getRow(i);
        if(cl.size() > rank)selected_header = cl.get(rank);
        updateInfo();
    }

    private void updateInfo()
    {
        if(selected_header == null)return;
        lbl_artist.setText(resizeString(selected_header.getArtist(), 40));
        lbl_title.setText(resizeString(selected_header.getTitle(), 30));
        lbl_filename.setText(resizeString(selected_header.getSource().getName(), 30));
        lbl_genre.setText(resizeString(selected_header.getGenre(), 30));
        lbl_level.setText(selected_header.getLevel()+"");
        lbl_bpm.setText(Float.toString((float)selected_header.getBPM()*100/100));
        lbl_notes.setText(selected_header.getNoteCount()+"");
	lbl_keys.setText(selected_header.getKeys()+"");
        int d = selected_header.getDuration();

        lbl_time.setText((d/60)+":"+(d%60));

        BufferedImage i = selected_header.getCover();

        if(i != null)
        lbl_cover.setIcon(new ImageIcon(i.getScaledInstance(
                lbl_cover.getWidth(),
                lbl_cover.getHeight(),
                BufferedImage.SCALE_SMOOTH
                )));
        else
            lbl_cover.setIcon(null);
    }

    private String resizeString(String string, int size)
    {
        if(string == null)return "";
        if(string.length() > size)
            string = string.substring(0, size)+"...";
        return string;
    }
}
