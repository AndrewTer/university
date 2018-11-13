package databaseapp;

/**
 *
 * @author terehin.andrey
 */

import java.awt.Color;
import java.awt.Frame;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MainFrame extends javax.swing.JFrame {
    private Connection con;
    // Параметры подключения к БД
    String url, user, password, username, userpassword;
    DefaultTableModel modela, modelap, modelj, modelr, modelrecord;
    String titleadmin;
    
    public MainFrame() {
        this.userpassword = null;
        this.username = null;
        this.password = null;
        this.user = null;
        this.url = null;
        this.con = null;
        initComponents();
        jlabelmessage.setVisible(false);
        jbuttonexit.setVisible(false);
        jpane.setEnabled(false);
        jbuttonautotoexcel.setVisible(false);
        jbuttonrecordtoexcel.setVisible(false);
        jbuttonrecordtoxml.setVisible(false);
        jbuttonautopersonneltoexcel.setVisible(false);
        jbuttonroutestoexcel.setVisible(false);
        jbuttonjournaltoexcel.setVisible(false);
        titleadmin = "user";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpane = new javax.swing.JTabbedPane();
        jpaneconnect = new javax.swing.JPanel();
        jbuttontestconnection = new javax.swing.JButton();
        jlabelconnect = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jpanelauth = new javax.swing.JTabbedPane();
        jpanelconnect = new javax.swing.JPanel();
        jlabelusername = new javax.swing.JLabel();
        jlabelpass = new javax.swing.JLabel();
        jloginfield = new javax.swing.JTextField();
        jpasswordfield = new javax.swing.JPasswordField();
        jbuttonauth = new javax.swing.JButton();
        jlabelerror = new javax.swing.JLabel();
        jbuttonautotoexcel = new javax.swing.JButton();
        jbuttonautopersonneltoexcel = new javax.swing.JButton();
        jbuttonroutestoexcel = new javax.swing.JButton();
        jbuttonjournaltoexcel = new javax.swing.JButton();
        jpanelparamconnection = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextFielddbname = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldhostname = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldport = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldusername = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPasswordFieldpass = new javax.swing.JPasswordField();
        jButtonsetparam = new javax.swing.JButton();
        jLabelerrorparamset = new javax.swing.JLabel();
        jpaneauto = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtableauto = new javax.swing.JTable();
        jPanelauto = new javax.swing.JPanel();
        jpaneautoadd = new javax.swing.JTabbedPane();
        jPanelautoadd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonautoadd = new javax.swing.JButton();
        jformatednumadd = new javax.swing.JFormattedTextField();
        jlabelcoloradd = new javax.swing.JLabel();
        jtextfieldcolorautoadd = new javax.swing.JTextField();
        jLabeladdautomark = new javax.swing.JLabel();
        jtextfieldautomarkadd = new javax.swing.JTextField();
        jLabeladdpersonnelidauto = new javax.swing.JLabel();
        jcomboboxpersonnelidaddauto = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        jpaneautodel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtextfieldselectedauto = new javax.swing.JTextField();
        jbuttondelauto = new javax.swing.JButton();
        jpaneautochange = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jlabelcoloradd1 = new javax.swing.JLabel();
        jLabeladdautomark1 = new javax.swing.JLabel();
        jLabeladdpersonnelidauto1 = new javax.swing.JLabel();
        jcomboboxpersonnelidchauto = new javax.swing.JComboBox<String>();
        jtextfieldautomarkch = new javax.swing.JTextField();
        jformatednumch = new javax.swing.JFormattedTextField();
        jtextfieldcolorautoch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButtonautoch = new javax.swing.JButton();
        jpaneautopersonnel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableautopersonnel = new javax.swing.JTable();
        jTabbedPaneautopers = new javax.swing.JTabbedPane();
        jPanelapadd = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldfirstnameadd = new javax.swing.JTextField();
        jTextFieldlastnameadd = new javax.swing.JTextField();
        jTextFieldpathernameadd = new javax.swing.JTextField();
        jButtonapadd = new javax.swing.JButton();
        jPaneldelap = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextFielddelid = new javax.swing.JTextField();
        jButtondelap = new javax.swing.JButton();
        jPanelapch = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldchfirst = new javax.swing.JTextField();
        jTextFieldchlast = new javax.swing.JTextField();
        jTextFieldchpather = new javax.swing.JTextField();
        jButtonchap = new javax.swing.JButton();
        jpaneroutes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtableroutes = new javax.swing.JTable();
        jTabbedPaneroutes = new javax.swing.JTabbedPane();
        jPaneladdroute = new javax.swing.JPanel();
        jLabelroutename = new javax.swing.JLabel();
        jTextFieldroutenameadd = new javax.swing.JTextField();
        jButtonaddroute = new javax.swing.JButton();
        jPaneldelr = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextFielddelr = new javax.swing.JTextField();
        jButtondelr = new javax.swing.JButton();
        jPanelchr = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldchr = new javax.swing.JTextField();
        jButtonchr = new javax.swing.JButton();
        jpanejournal = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtablejournal = new javax.swing.JTable();
        jTabbedPanejournal = new javax.swing.JTabbedPane();
        jPaneladdjournal = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jFormattedTextFieldtimeinadddata = new javax.swing.JFormattedTextField();
        jFormattedTextFieldaddtimeouttime = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jFormattedTextFieldaddtimeintime = new javax.swing.JFormattedTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jComboBoxaddjournalauto = new javax.swing.JComboBox();
        jComboBoxaddjournalroute = new javax.swing.JComboBox();
        jButtonaddjournal = new javax.swing.JButton();
        jFormattedTextFieldtimeoutadddata = new javax.swing.JFormattedTextField();
        jPaneljournaldel = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldselectedidjournal = new javax.swing.JTextField();
        jButtondelj = new javax.swing.JButton();
        jPaneljournalch = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jButtonchjournal = new javax.swing.JButton();
        jComboBoxchjournalauto = new javax.swing.JComboBox();
        jComboBoxchjournalroute = new javax.swing.JComboBox();
        jFormattedTextFieldchtimeoutdate = new javax.swing.JFormattedTextField();
        jFormattedTextFieldchtimeindate = new javax.swing.JFormattedTextField();
        jFormattedTextFieldchtimeouttime = new javax.swing.JFormattedTextField();
        jFormattedTextFieldchtimeintime = new javax.swing.JFormattedTextField();
        jpanelrecord = new javax.swing.JPanel();
        jLabelinforecord = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxroutes = new javax.swing.JComboBox<String>();
        jButtonrecord = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablerecord = new javax.swing.JTable();
        jbuttonrecordtoxml = new javax.swing.JButton();
        jbuttonrecordtoexcel = new javax.swing.JButton();
        jPanelcoursor = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextAreacoursor = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jSpinnersum = new javax.swing.JSpinner();
        jButtonprem = new javax.swing.JButton();
        jLabelprem = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jstart = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jstop = new javax.swing.JFormattedTextField();
        jbuttontotxt = new javax.swing.JButton();
        jlabelmessage = new javax.swing.JLabel();
        jbuttonexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(50, 22));
        setMinimumSize(new java.awt.Dimension(460, 240));
        setName("mainframe"); // NOI18N
        setSize(new java.awt.Dimension(460, 240));

        jpane.setMaximumSize(new java.awt.Dimension(790, 490));
        jpane.setMinimumSize(new java.awt.Dimension(790, 490));
        jpane.setPreferredSize(new java.awt.Dimension(790, 490));

        jbuttontestconnection.setText("Проверить подключение к БД");
        jbuttontestconnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttontestconnectionActionPerformed(evt);
            }
        });

        jlabelconnect.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jlabelconnect.setForeground(new java.awt.Color(0, 153, 51));
        jlabelconnect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelconnect.setText("Ожидание подключения..");
        jlabelconnect.setToolTipText("");
        jlabelconnect.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jlabelusername.setText("Логин");
        jlabelusername.setDoubleBuffered(true);
        jlabelusername.setEnabled(false);

        jlabelpass.setText("Пароль");
        jlabelpass.setEnabled(false);

        jloginfield.setEnabled(false);

        jpasswordfield.setEnabled(false);

        jbuttonauth.setText("Войти");
        jbuttonauth.setEnabled(false);
        jbuttonauth.setName("buttonauth"); // NOI18N
        jbuttonauth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonauthActionPerformed(evt);
            }
        });

        jlabelerror.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jlabelerror.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelerror.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jbuttonautotoexcel.setText("Вывод таблицы auto в Excel");
        jbuttonautotoexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonautotoexcelActionPerformed(evt);
            }
        });

        jbuttonautopersonneltoexcel.setText("Вывод таблицы auto_personnel в Excel");
        jbuttonautopersonneltoexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonautopersonneltoexcelActionPerformed(evt);
            }
        });

        jbuttonroutestoexcel.setText("Вывод таблицы routes в Excel");
        jbuttonroutestoexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonroutestoexcelActionPerformed(evt);
            }
        });

        jbuttonjournaltoexcel.setText("Вывод таблицы journal в Excel");
        jbuttonjournaltoexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonjournaltoexcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelconnectLayout = new javax.swing.GroupLayout(jpanelconnect);
        jpanelconnect.setLayout(jpanelconnectLayout);
        jpanelconnectLayout.setHorizontalGroup(
            jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelconnectLayout.createSequentialGroup()
                .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelconnectLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabelerror, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpanelconnectLayout.createSequentialGroup()
                                .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelconnectLayout.createSequentialGroup()
                                        .addComponent(jlabelusername, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75))
                                    .addGroup(jpanelconnectLayout.createSequentialGroup()
                                        .addComponent(jlabelpass)
                                        .addGap(130, 130, 130)))
                                .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jloginfield)
                                    .addComponent(jpasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpanelconnectLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jbuttonauth, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpanelconnectLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbuttonroutestoexcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbuttonautotoexcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbuttonautopersonneltoexcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbuttonjournaltoexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelconnectLayout.setVerticalGroup(
            jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelconnectLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelusername)
                    .addComponent(jloginfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelpass)
                    .addComponent(jpasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jbuttonauth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabelerror, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonautotoexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbuttonautopersonneltoexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbuttonroutestoexcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbuttonjournaltoexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlabelusername.getAccessibleContext().setAccessibleName("loginlabel");
        jlabelpass.getAccessibleContext().setAccessibleName("passwordlabel");
        jloginfield.getAccessibleContext().setAccessibleName("loginfield");
        jpasswordfield.getAccessibleContext().setAccessibleName("passwordfield");
        jbuttonauth.getAccessibleContext().setAccessibleName("buttonauth");
        jlabelerror.getAccessibleContext().setAccessibleName("labelerror");

        jpanelauth.addTab("Авторизация", jpanelconnect);

        jLabel21.setText("Database name:");

        jTextFielddbname.setText("car_park");

        jLabel22.setText("Host name/address:");

        jTextFieldhostname.setText("localhost");

        jLabel23.setText("Port:");

        jTextFieldport.setText("5432");

        jLabel24.setText("Username:");

        jTextFieldusername.setText("postgres");

        jLabel25.setText("Password:");

        jPasswordFieldpass.setText("caan");

        jButtonsetparam.setText("Задать параметры");
        jButtonsetparam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsetparamActionPerformed(evt);
            }
        });

        jLabelerrorparamset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpanelparamconnectionLayout = new javax.swing.GroupLayout(jpanelparamconnection);
        jpanelparamconnection.setLayout(jpanelparamconnectionLayout);
        jpanelparamconnectionLayout.setHorizontalGroup(
            jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelparamconnectionLayout.createSequentialGroup()
                .addGroup(jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelerrorparamset, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanelparamconnectionLayout.createSequentialGroup()
                            .addGap(170, 170, 170)
                            .addGroup(jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23)
                                .addComponent(jLabel24)
                                .addComponent(jLabel25))
                            .addGap(100, 100, 100)
                            .addGroup(jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFielddbname, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addComponent(jTextFieldhostname)
                                .addComponent(jTextFieldport)
                                .addComponent(jTextFieldusername)
                                .addComponent(jPasswordFieldpass)))
                        .addGroup(jpanelparamconnectionLayout.createSequentialGroup()
                            .addGap(297, 297, 297)
                            .addComponent(jButtonsetparam, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jpanelparamconnectionLayout.setVerticalGroup(
            jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelparamconnectionLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFielddbname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextFieldhostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextFieldport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextFieldusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelparamconnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jPasswordFieldpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonsetparam)
                .addGap(18, 18, 18)
                .addComponent(jLabelerrorparamset)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jpanelauth.addTab("Параметры подключения к БД", jpanelparamconnection);

        javax.swing.GroupLayout jpaneconnectLayout = new javax.swing.GroupLayout(jpaneconnect);
        jpaneconnect.setLayout(jpaneconnectLayout);
        jpaneconnectLayout.setHorizontalGroup(
            jpaneconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneconnectLayout.createSequentialGroup()
                .addGap(794, 794, 794)
                .addComponent(jSeparator1))
            .addGroup(jpaneconnectLayout.createSequentialGroup()
                .addGroup(jpaneconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpaneconnectLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jbuttontestconnection)
                        .addGap(34, 34, 34)
                        .addComponent(jlabelconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneconnectLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jpanelauth, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jpaneconnectLayout.setVerticalGroup(
            jpaneconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneconnectLayout.createSequentialGroup()
                .addGroup(jpaneconnectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttontestconnection)
                    .addComponent(jlabelconnect))
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jpanelauth, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jbuttontestconnection.getAccessibleContext().setAccessibleName("buttontestconnect");
        jlabelconnect.getAccessibleContext().setAccessibleName("Conn");

        jpane.addTab("Подключение | Авторизация", jpaneconnect);
        jpaneconnect.getAccessibleContext().setAccessibleName("tabauth");

        jtableauto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtableauto.setToolTipText("");
        jtableauto.setMaximumSize(new java.awt.Dimension(100, 1000));
        jtableauto.setMinimumSize(new java.awt.Dimension(100, 250));
        jtableauto.setPreferredSize(new java.awt.Dimension(100, 400));
        jtableauto.setRowHeight(25);
        jtableauto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableautoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtableauto);
        jtableauto.getAccessibleContext().setAccessibleParent(jpaneauto);

        jPanelautoadd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));

        jLabel1.setText("num*");
        jLabel1.setName(""); // NOI18N

        jButtonautoadd.setText("Добавить");
        jButtonautoadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonautoaddActionPerformed(evt);
            }
        });

        try {
            jformatednumadd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAAAAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformatednumadd.setToolTipText("");

        jlabelcoloradd.setText("color");

        jLabeladdautomark.setText("mark");

        jLabeladdpersonnelidauto.setText("personnel_d");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        jLabel2.setText("*num должен содержать 6 символов");

        javax.swing.GroupLayout jPanelautoaddLayout = new javax.swing.GroupLayout(jPanelautoadd);
        jPanelautoadd.setLayout(jPanelautoaddLayout);
        jPanelautoaddLayout.setHorizontalGroup(
            jPanelautoaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelautoaddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonautoadd)
                .addGap(304, 304, 304))
            .addGroup(jPanelautoaddLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanelautoaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jlabelcoloradd))
                .addGap(40, 40, 40)
                .addGroup(jPanelautoaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jformatednumadd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextfieldcolorautoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addGroup(jPanelautoaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabeladdautomark)
                    .addComponent(jLabeladdpersonnelidauto))
                .addGap(37, 37, 37)
                .addGroup(jPanelautoaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtextfieldautomarkadd, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcomboboxpersonnelidaddauto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanelautoaddLayout.setVerticalGroup(
            jPanelautoaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelautoaddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelautoaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jformatednumadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeladdautomark)
                    .addComponent(jtextfieldautomarkadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelautoaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextfieldcolorautoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeladdpersonnelidauto)
                    .addComponent(jlabelcoloradd)
                    .addComponent(jcomboboxpersonnelidaddauto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanelautoaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonautoadd)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("addnumlabel");
        jButtonautoadd.getAccessibleContext().setAccessibleName("jbuttonautoadd");
        jlabelcoloradd.getAccessibleContext().setAccessibleName("addcolorauto");
        jLabeladdautomark.getAccessibleContext().setAccessibleName("addmarklabel");
        jLabeladdpersonnelidauto.getAccessibleContext().setAccessibleName("jLabelpersonnelidaddauto");

        jpaneautoadd.addTab("Добавление", jPanelautoadd);

        jLabel7.setText("Выбранный номер авто:");

        jtextfieldselectedauto.setEditable(false);

        jbuttondelauto.setText("Удалить");
        jbuttondelauto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttondelautoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpaneautodelLayout = new javax.swing.GroupLayout(jpaneautodel);
        jpaneautodel.setLayout(jpaneautodelLayout);
        jpaneautodelLayout.setHorizontalGroup(
            jpaneautodelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneautodelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpaneautodelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbuttondelauto, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpaneautodelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jtextfieldselectedauto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(443, Short.MAX_VALUE))
        );
        jpaneautodelLayout.setVerticalGroup(
            jpaneautodelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneautodelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpaneautodelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtextfieldselectedauto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbuttondelauto)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jpaneautoadd.addTab("Удаление", jpaneautodel);

        jLabel8.setText("num*");
        jLabel8.setName(""); // NOI18N

        jlabelcoloradd1.setText("color");

        jLabeladdautomark1.setText("mark");

        jLabeladdpersonnelidauto1.setText("personnel_id");

        try {
            jformatednumch.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAAAAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jformatednumch.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        jLabel9.setText("*num должен содержать 6 символов");

        jButtonautoch.setText("Редактировать");
        jButtonautoch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonautochActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpaneautochangeLayout = new javax.swing.GroupLayout(jpaneautochange);
        jpaneautochange.setLayout(jpaneautochangeLayout);
        jpaneautochangeLayout.setHorizontalGroup(
            jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneautochangeLayout.createSequentialGroup()
                .addContainerGap(333, Short.MAX_VALUE)
                .addComponent(jButtonautoch)
                .addGap(298, 298, 298))
            .addGroup(jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpaneautochangeLayout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addGroup(jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneautochangeLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(421, 421, 421))
                        .addGroup(jpaneautochangeLayout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addGroup(jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jlabelcoloradd1))
                            .addGap(40, 40, 40)
                            .addGroup(jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jformatednumch, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextfieldcolorautoch, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(121, 121, 121)
                            .addGroup(jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabeladdautomark1)
                                .addComponent(jLabeladdpersonnelidauto1))
                            .addGap(37, 37, 37)
                            .addGroup(jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtextfieldautomarkch, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcomboboxpersonnelidchauto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
        jpaneautochangeLayout.setVerticalGroup(
            jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneautochangeLayout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(jButtonautoch)
                .addContainerGap())
            .addGroup(jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpaneautochangeLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jformatednumch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabeladdautomark1)
                        .addComponent(jtextfieldautomarkch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jpaneautochangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtextfieldcolorautoch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabeladdpersonnelidauto1)
                        .addComponent(jlabelcoloradd1)
                        .addComponent(jcomboboxpersonnelidchauto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(15, 15, 15)))
        );

        jpaneautoadd.addTab("Редактирование", jpaneautochange);

        javax.swing.GroupLayout jPanelautoLayout = new javax.swing.GroupLayout(jPanelauto);
        jPanelauto.setLayout(jPanelautoLayout);
        jPanelautoLayout.setHorizontalGroup(
            jPanelautoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelautoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpaneautoadd)
                .addContainerGap())
        );
        jPanelautoLayout.setVerticalGroup(
            jPanelautoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaneautoadd)
        );

        jpaneautoadd.getAccessibleContext().setAccessibleName("tabautoadd");

        javax.swing.GroupLayout jpaneautoLayout = new javax.swing.GroupLayout(jpaneauto);
        jpaneauto.setLayout(jpaneautoLayout);
        jpaneautoLayout.setHorizontalGroup(
            jpaneautoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jpaneautoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelauto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpaneautoLayout.setVerticalGroup(
            jpaneautoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneautoLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelauto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpane.addTab("Таблица auto", jpaneauto);
        jpaneauto.getAccessibleContext().setAccessibleName("tabauto");

        jtableautopersonnel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtableautopersonnel.setMaximumSize(new java.awt.Dimension(100, 1000));
        jtableautopersonnel.setMinimumSize(new java.awt.Dimension(100, 250));
        jtableautopersonnel.setPreferredSize(new java.awt.Dimension(100, 450));
        jtableautopersonnel.setRowHeight(25);
        jtableautopersonnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableautopersonnelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtableautopersonnel);

        jLabel10.setText("first_name");

        jLabel11.setText("last_name");

        jLabel12.setText("pather_name");

        jButtonapadd.setText("Добавить");
        jButtonapadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonapaddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelapaddLayout = new javax.swing.GroupLayout(jPanelapadd);
        jPanelapadd.setLayout(jPanelapaddLayout);
        jPanelapaddLayout.setHorizontalGroup(
            jPanelapaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelapaddLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanelapaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanelapaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldfirstnameadd)
                    .addComponent(jTextFieldlastnameadd, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelapaddLayout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addGroup(jPanelapaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonapadd, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldpathernameadd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanelapaddLayout.setVerticalGroup(
            jPanelapaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelapaddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelapaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldfirstnameadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanelapaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldpathernameadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelapaddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldlastnameadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButtonapadd)
                .addGap(24, 24, 24))
        );

        jTabbedPaneautopers.addTab("Добавление", jPanelapadd);

        jLabel13.setText("Выбранный id кадра:");

        jTextFielddelid.setEditable(false);

        jButtondelap.setText("Удалить");
        jButtondelap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondelapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaneldelapLayout = new javax.swing.GroupLayout(jPaneldelap);
        jPaneldelap.setLayout(jPaneldelapLayout);
        jPaneldelapLayout.setHorizontalGroup(
            jPaneldelapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneldelapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneldelapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtondelap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPaneldelapLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(26, 26, 26)
                        .addComponent(jTextFielddelid, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(513, Short.MAX_VALUE))
        );
        jPaneldelapLayout.setVerticalGroup(
            jPaneldelapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneldelapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneldelapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFielddelid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtondelap)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPaneautopers.addTab("Удаление", jPaneldelap);

        jLabel14.setText("first_name");

        jLabel15.setText("last_name");

        jLabel16.setText("pather_name");

        jButtonchap.setText("Редактировать");
        jButtonchap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonchapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelapchLayout = new javax.swing.GroupLayout(jPanelapch);
        jPanelapch.setLayout(jPanelapchLayout);
        jPanelapchLayout.setHorizontalGroup(
            jPanelapchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelapchLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(jPanelapchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelapchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldchfirst)
                    .addComponent(jTextFieldchlast, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelapchLayout.createSequentialGroup()
                .addContainerGap(320, Short.MAX_VALUE)
                .addGroup(jPanelapchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelapchLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldchpather, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelapchLayout.createSequentialGroup()
                        .addComponent(jButtonchap, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))))
        );
        jPanelapchLayout.setVerticalGroup(
            jPanelapchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelapchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelapchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldchfirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelapchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldchpather, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelapchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldchlast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButtonchap)
                .addContainerGap())
        );

        jTabbedPaneautopers.addTab("Редактирование", jPanelapch);

        javax.swing.GroupLayout jpaneautopersonnelLayout = new javax.swing.GroupLayout(jpaneautopersonnel);
        jpaneautopersonnel.setLayout(jpaneautopersonnelLayout);
        jpaneautopersonnelLayout.setHorizontalGroup(
            jpaneautopersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(jpaneautopersonnelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPaneautopers, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpaneautopersonnelLayout.setVerticalGroup(
            jpaneautopersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneautopersonnelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPaneautopers, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jpane.addTab("Таблица auto_personnel", jpaneautopersonnel);

        jtableroutes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtableroutes.setMaximumSize(new java.awt.Dimension(100, 1000));
        jtableroutes.setMinimumSize(new java.awt.Dimension(100, 250));
        jtableroutes.setPreferredSize(new java.awt.Dimension(100, 450));
        jtableroutes.setRowHeight(25);
        jtableroutes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableroutesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtableroutes);
        jtableroutes.getAccessibleContext().setAccessibleName("");

        jLabelroutename.setText("name");

        jButtonaddroute.setText("Добавить");
        jButtonaddroute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaddrouteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaneladdrouteLayout = new javax.swing.GroupLayout(jPaneladdroute);
        jPaneladdroute.setLayout(jPaneladdrouteLayout);
        jPaneladdrouteLayout.setHorizontalGroup(
            jPaneladdrouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneladdrouteLayout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jButtonaddroute, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneladdrouteLayout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addComponent(jLabelroutename)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldroutenameadd, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );
        jPaneladdrouteLayout.setVerticalGroup(
            jPaneladdrouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneladdrouteLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPaneladdrouteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelroutename)
                    .addComponent(jTextFieldroutenameadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonaddroute)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPaneroutes.addTab("Добавление", jPaneladdroute);

        jLabel17.setText("Выбранный id маршрута:");

        jTextFielddelr.setEditable(false);

        jButtondelr.setText("Удалить");
        jButtondelr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondelrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaneldelrLayout = new javax.swing.GroupLayout(jPaneldelr);
        jPaneldelr.setLayout(jPaneldelrLayout);
        jPaneldelrLayout.setHorizontalGroup(
            jPaneldelrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneldelrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneldelrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtondelr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPaneldelrLayout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFielddelr, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(477, Short.MAX_VALUE))
        );
        jPaneldelrLayout.setVerticalGroup(
            jPaneldelrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneldelrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneldelrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFielddelr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtondelr)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jTabbedPaneroutes.addTab("Удаление", jPaneldelr);

        jLabel18.setText("name");

        jButtonchr.setText("Редактировать");
        jButtonchr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonchrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelchrLayout = new javax.swing.GroupLayout(jPanelchr);
        jPanelchr.setLayout(jPanelchrLayout);
        jPanelchrLayout.setHorizontalGroup(
            jPanelchrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelchrLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel18)
                .addGap(27, 27, 27)
                .addComponent(jTextFieldchr, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelchrLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonchr)
                .addGap(292, 292, 292))
        );
        jPanelchrLayout.setVerticalGroup(
            jPanelchrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelchrLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelchrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldchr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButtonchr)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jTabbedPaneroutes.addTab("Редактирование", jPanelchr);

        javax.swing.GroupLayout jpaneroutesLayout = new javax.swing.GroupLayout(jpaneroutes);
        jpaneroutes.setLayout(jpaneroutesLayout);
        jpaneroutesLayout.setHorizontalGroup(
            jpaneroutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(jpaneroutesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTabbedPaneroutes, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpaneroutesLayout.setVerticalGroup(
            jpaneroutesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneroutesLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPaneroutes)
                .addContainerGap())
        );

        jpane.addTab("Таблица routes", jpaneroutes);

        jtablejournal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtablejournal.setMaximumSize(new java.awt.Dimension(100, 1000));
        jtablejournal.setMinimumSize(new java.awt.Dimension(100, 250));
        jtablejournal.setPreferredSize(new java.awt.Dimension(100, 450));
        jtablejournal.setRowHeight(25);
        jtablejournal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtablejournalMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtablejournal);

        jLabel19.setText("time_out:     date");

        jLabel20.setText("time_in:       date");

        jFormattedTextFieldtimeinadddata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jFormattedTextFieldtimeinadddata.setText("yyyy-MM-dd");

        jFormattedTextFieldaddtimeouttime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        jFormattedTextFieldaddtimeouttime.setText("H:mm:ss");
        jFormattedTextFieldaddtimeouttime.setToolTipText("");

        jLabel27.setText("time");

        jLabel28.setText("time");

        jFormattedTextFieldaddtimeintime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        jFormattedTextFieldaddtimeintime.setText("H:mm:ss");

        jLabel29.setText("auto_id");

        jLabel30.setText("route_id");

        jButtonaddjournal.setText("Добавить");
        jButtonaddjournal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaddjournalActionPerformed(evt);
            }
        });

        jFormattedTextFieldtimeoutadddata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jFormattedTextFieldtimeoutadddata.setText("yyyy-MM-dd");

        javax.swing.GroupLayout jPaneladdjournalLayout = new javax.swing.GroupLayout(jPaneladdjournal);
        jPaneladdjournal.setLayout(jPaneladdjournalLayout);
        jPaneladdjournalLayout.setHorizontalGroup(
            jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneladdjournalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFormattedTextFieldtimeinadddata, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldtimeoutadddata))
                .addGap(18, 18, 18)
                .addGroup(jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneladdjournalLayout.createSequentialGroup()
                        .addGroup(jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormattedTextFieldaddtimeouttime)
                            .addComponent(jFormattedTextFieldaddtimeintime, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addGroup(jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxaddjournalauto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxaddjournalroute, 0, 81, Short.MAX_VALUE)))
                    .addComponent(jButtonaddjournal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPaneladdjournalLayout.setVerticalGroup(
            jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneladdjournalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel27)
                    .addComponent(jFormattedTextFieldaddtimeouttime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jComboBoxaddjournalauto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldtimeoutadddata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPaneladdjournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jFormattedTextFieldtimeinadddata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jFormattedTextFieldaddtimeintime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBoxaddjournalroute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButtonaddjournal)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPanejournal.addTab("Добавление", jPaneladdjournal);

        jLabel26.setText("Выбранный id строки журнала:");

        jTextFieldselectedidjournal.setEditable(false);

        jButtondelj.setText("Удалить");
        jButtondelj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondeljActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaneljournaldelLayout = new javax.swing.GroupLayout(jPaneljournaldel);
        jPaneljournaldel.setLayout(jPaneljournaldelLayout);
        jPaneljournaldelLayout.setHorizontalGroup(
            jPaneljournaldelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneljournaldelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneljournaldelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtondelj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPaneljournaldelLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldselectedidjournal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(453, Short.MAX_VALUE))
        );
        jPaneljournaldelLayout.setVerticalGroup(
            jPaneljournaldelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneljournaldelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneljournaldelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldselectedidjournal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtondelj)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jTabbedPanejournal.addTab("Удаление", jPaneljournaldel);

        jLabel31.setText("time_out:     date");

        jLabel32.setText("time_in:       date");

        jLabel33.setText("time");

        jLabel34.setText("time");

        jLabel35.setText("auto_id");

        jLabel36.setText("route_id");

        jButtonchjournal.setText("Редактировать");
        jButtonchjournal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonchjournalActionPerformed(evt);
            }
        });

        jFormattedTextFieldchtimeoutdate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jFormattedTextFieldchtimeoutdate.setText("yyyy-MM-dd");

        jFormattedTextFieldchtimeindate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jFormattedTextFieldchtimeindate.setText("yyyy-MM-dd");

        jFormattedTextFieldchtimeouttime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        jFormattedTextFieldchtimeouttime.setText("H:mm:ss");

        jFormattedTextFieldchtimeintime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        jFormattedTextFieldchtimeintime.setText("H:mm:ss");

        javax.swing.GroupLayout jPaneljournalchLayout = new javax.swing.GroupLayout(jPaneljournalch);
        jPaneljournalch.setLayout(jPaneljournalchLayout);
        jPaneljournalchLayout.setHorizontalGroup(
            jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneljournalchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFormattedTextFieldchtimeoutdate, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jFormattedTextFieldchtimeindate))
                .addGap(18, 18, 18)
                .addGroup(jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneljournalchLayout.createSequentialGroup()
                        .addGroup(jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPaneljournalchLayout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldchtimeouttime, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPaneljournalchLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextFieldchtimeintime)))
                        .addGap(45, 45, 45)
                        .addGroup(jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(25, 25, 25)
                        .addGroup(jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxchjournalauto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxchjournalroute, 0, 80, Short.MAX_VALUE)))
                    .addComponent(jButtonchjournal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPaneljournalchLayout.setVerticalGroup(
            jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneljournalchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel33)
                    .addComponent(jLabel35)
                    .addComponent(jComboBoxchjournalauto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldchtimeoutdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldchtimeouttime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPaneljournalchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel34)
                    .addComponent(jLabel36)
                    .addComponent(jComboBoxchjournalroute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldchtimeindate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldchtimeintime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButtonchjournal)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPanejournal.addTab("Редактирование", jPaneljournalch);

        javax.swing.GroupLayout jpanejournalLayout = new javax.swing.GroupLayout(jpanejournal);
        jpanejournal.setLayout(jpanejournalLayout);
        jpanejournalLayout.setHorizontalGroup(
            jpanejournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(jpanejournalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPanejournal, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanejournalLayout.setVerticalGroup(
            jpanejournalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanejournalLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPanejournal)
                .addContainerGap())
        );

        jpane.addTab("Таблица journal", jpanejournal);

        jLabelinforecord.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabelinforecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelinforecord.setText("Самое короткое время проезда по заданному маршруту и автомобиль, поставивший рекорд");

        jLabel3.setText("Выбранный маршрут:");

        jButtonrecord.setLabel("Вывести");
        jButtonrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonrecordActionPerformed(evt);
            }
        });

        jtablerecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtablerecord.setEnabled(false);
        jtablerecord.setRowHeight(20);
        jScrollPane1.setViewportView(jtablerecord);

        jbuttonrecordtoxml.setText("В файл xml");
        jbuttonrecordtoxml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonrecordtoxmlActionPerformed(evt);
            }
        });

        jbuttonrecordtoexcel.setText("В файл Excel");
        jbuttonrecordtoexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonrecordtoexcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelrecordLayout = new javax.swing.GroupLayout(jpanelrecord);
        jpanelrecord.setLayout(jpanelrecordLayout);
        jpanelrecordLayout.setHorizontalGroup(
            jpanelrecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelrecordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelrecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelinforecord, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelrecordLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpanelrecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonrecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpanelrecordLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxroutes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(164, 164, 164)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelrecordLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanelrecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jbuttonrecordtoxml, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbuttonrecordtoexcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(144, 144, 144))
        );
        jpanelrecordLayout.setVerticalGroup(
            jpanelrecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelrecordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelinforecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelrecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxroutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonrecord)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbuttonrecordtoxml)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbuttonrecordtoexcel)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        jButtonrecord.getAccessibleContext().setAccessibleName("jButtonrecord");

        jpane.addTab("Рекордсмены", jpanelrecord);

        jTextAreacoursor.setEditable(false);
        jTextAreacoursor.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextAreacoursor.setColumns(20);
        jTextAreacoursor.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jTextAreacoursor.setLineWrap(true);
        jTextAreacoursor.setRows(5);
        jTextAreacoursor.setText("Премиальные денежные средства выдаются трем водителям, проехавшим за минимальное время наибольшее количество маршрутов, причем 50% от премиальной суммы выдается первому водителю, а остальным двум выдается 30% и 20% в соответствии с их успехами");
        jTextAreacoursor.setBorder(null);
        jScrollPane6.setViewportView(jTextAreacoursor);

        jLabel4.setText("Сумма премиальных:");

        jButtonprem.setText("Распределить премию");
        jButtonprem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonpremActionPerformed(evt);
            }
        });

        jLabelprem.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        jLabelprem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setText("Дата начала:");

        jstart.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jstart.setText("2017-12-12");

        jLabel6.setText("Дата окончания:");

        jstop.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jstop.setText("2020-12-12");

        jbuttontotxt.setText("Вывод в файл");
        jbuttontotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttontotxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelcoursorLayout = new javax.swing.GroupLayout(jPanelcoursor);
        jPanelcoursor.setLayout(jPanelcoursorLayout);
        jPanelcoursorLayout.setHorizontalGroup(
            jPanelcoursorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelcoursorLayout.createSequentialGroup()
                .addGroup(jPanelcoursorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelcoursorLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanelcoursorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelprem, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelcoursorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelcoursorLayout.createSequentialGroup()
                                    .addGroup(jPanelcoursorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanelcoursorLayout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(18, 18, 18)
                                            .addComponent(jSpinnersum, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelcoursorLayout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jstart, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6)
                                    .addGap(41, 41, 41)
                                    .addComponent(jstop, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelcoursorLayout.createSequentialGroup()
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9)))))
                    .addGroup(jPanelcoursorLayout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jButtonprem, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelcoursorLayout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jbuttontotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanelcoursorLayout.setVerticalGroup(
            jPanelcoursorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelcoursorLayout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelcoursorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnersum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelcoursorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jstart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jstop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonprem)
                .addGap(18, 18, 18)
                .addComponent(jLabelprem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbuttontotxt)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        jpane.addTab("Премии", jPanelcoursor);

        jlabelmessage.setBackground(new java.awt.Color(255, 255, 255));
        jlabelmessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelmessage.setText("Username");

        jbuttonexit.setText("Выйти");
        jbuttonexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelmessage, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbuttonexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jpane, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonexit, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelmessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpane, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
        );

        jpane.getAccessibleContext().setAccessibleName("tab");
        jlabelmessage.getAccessibleContext().setAccessibleName("jlabelmessage");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public Connection getCon() {
        return this.con;
    }
    
    // Подключение к БД
    private void jbuttontestconnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttontestconnectionActionPerformed
        String testconn = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            if ((url == null) || (user == null) || (password == null))
            {
                testconn = "Сначала задайте параметры подключения к БД!";
                jlabelconnect.setForeground(Color.RED);
                jlabelconnect.setText(testconn); 
            } else
            {
                con = DriverManager.getConnection(this.url, this.user, this.password);
                testconn = "Успешно подключено!";
                jlabelconnect.setForeground(Color.BLUE);
                jlabelconnect.setText(testconn);
                jlabelusername.setEnabled(true);
                jlabelpass.setEnabled(true);
                jloginfield.setEnabled(true);
                jpasswordfield.setEnabled(true);
                jbuttonauth.setEnabled(true);
            }
        } catch (SQLException ex) {
            testconn = "Ошибка при подключении!";
            jlabelconnect.setForeground(Color.RED);
            jlabelconnect.setText(testconn);
            jlabelusername.setEnabled(false);
            jlabelpass.setEnabled(false);
            jbuttonauth.setEnabled(false);
            jloginfield.setEnabled(false);
            jpasswordfield.setEnabled(false);
            jbuttonexitActionPerformed(evt);
        }
    }//GEN-LAST:event_jbuttontestconnectionActionPerformed

    // Авторизация пользователя
    private void jbuttonauthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonauthActionPerformed
        Statement stmt;
        ResultSet rs;
        String errormes;
        int countuser = 0;
        
        username = jloginfield.getText();
        jtablerecord.setVisible(false);
        jtablerecord.setShowGrid(false);
        jbuttontotxt.setVisible(false);
        
        //Шифрование введённого пользователем пароля 
        userpassword = String.valueOf(jpasswordfield.getPassword());
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        byte[] digest = md.digest(userpassword.getBytes(StandardCharsets.UTF_8));
        String md5 = DatatypeConverter.printHexBinary(digest);
        userpassword = md5;
        
        try {
            stmt = con.createStatement();
            if ((!jloginfield.getText().isEmpty()) && !(String.valueOf(jpasswordfield.getPassword()).isEmpty()))
            {
                rs = stmt.executeQuery("SELECT * FROM users WHERE (name = '"+username+"' AND password = '"+userpassword+"' AND title = 'user')");
                while (rs.next()) 
                {
                    countuser++;
                }
                
                if (countuser == 1)
                {
                    JOptionPane.showMessageDialog(null, "Добро пожаловать, "+username+"!");
                    jlabelmessage.setForeground(Color.BLUE);
                    jlabelmessage.setText("Вы зашли как "+username);
                    jlabelmessage.setVisible(true);
                    jbuttonexit.setVisible(true);
                    jloginfield.setText(null);
                    jpasswordfield.setText(null);
                    jlabelerror.setText(null);
                    jpane.setEnabled(true);
                    jpanelconnect.setVisible(false);
                    
                    try
                    {
                        // ЗАПОЛНЕНИЕ ТАБЛИЦ
                        // Получение данных из БД
                        getDataFromDBTableAuto("user");
                        getDataFromDBTableAutoPersonnel("user");
                        getDataFromDBTableRoutes("user");
                        getDataFromDBTableJournal("user");

                        // ЗАПОЛНЕНИЕ COMBOBOX ДАННЫМИ ИЗ БД
                        getDataFromDBAutoPersonnelId();
                        getDataFromDBRoutes();
                        getDataFromDBAutoId();
                    }
                    catch(Exception ex)
                    {
                    }
                    
                    jPanelauto.setVisible(false);
                    jTabbedPaneautopers.setVisible(false);
                    jTabbedPaneroutes.setVisible(false);
                    jTabbedPanejournal.setVisible(false);
                    
                    countuser = 0;
                } else
                {
                    ResultSet rss;
                    int countadmin = 0;
                    rss = stmt.executeQuery("SELECT * FROM users WHERE (name = '"+username+"' AND password = '"+userpassword+"' AND title = 'admin')");
            
                    while (rss.next()) 
                    {
                        countadmin++;
                    }
                
                    if (countadmin == 1)
                    {
                        JOptionPane.showMessageDialog(null, "Добро пожаловать, "+username+"!");
                        jlabelmessage.setForeground(Color.BLUE);
                        jlabelmessage.setText("Вы зашли как "+username);
                        jlabelmessage.setVisible(true);
                        jbuttonexit.setVisible(true);
                        jloginfield.setText(null);
                        jpasswordfield.setText(null);
                        jlabelerror.setText(null);
                        jpane.setEnabled(true);
                        jpanelconnect.setVisible(false);
                        jbuttonautotoexcel.setVisible(true);
                        jbuttonrecordtoexcel.setVisible(true);
                        jbuttonrecordtoxml.setVisible(true);
                        jbuttonautopersonneltoexcel.setVisible(true);
                        jbuttonroutestoexcel.setVisible(true);
                        jbuttonjournaltoexcel.setVisible(true);

                        try
                        {
                            // ЗАПОЛНЕНИЕ ТАБЛИЦ
                            // Получение данных из БД
                            getDataFromDBTableAuto("admin");
                            getDataFromDBTableAutoPersonnel("admin");
                            getDataFromDBTableRoutes("admin");
                            getDataFromDBTableJournal("admin");

                            // ЗАПОЛНЕНИЕ COMBOBOX ДАННЫМИ ИЗ БД
                            getDataFromDBAutoPersonnelId();
                            getDataFromDBRoutes();
                            getDataFromDBAutoId();
                            titleadmin = "admin";
                        }
                        catch(Exception ex)
                        {
                        }
                       
                        jPanelauto.setVisible(true);
                        jTabbedPaneautopers.setVisible(true);
                        jTabbedPaneroutes.setVisible(true);
                        jTabbedPanejournal.setVisible(true);
                    } else
                    {
                        errormes = "Такого пользователя не существует, либо пароль некорректный!";
                        jlabelerror.setForeground(Color.RED);
                        jlabelerror.setText(errormes);
                    }
                    countadmin = 0;
                }
            } else
            {
                errormes = "Следует заполнить все поля!";
                jlabelerror.setForeground(Color.RED);
                jlabelerror.setText(errormes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jbuttonauthActionPerformed

    // Получение уникальных id из таблицы auto_personnel
    public void getDataFromDBAutoPersonnelId() throws Exception
    {
        Vector result = new Vector();
        Statement stmt =  con.createStatement();
        
        String query = "SELECT id FROM auto_personnel ORDER BY id";
        // Выполнение запроса
        ResultSet resultSet = stmt.executeQuery(query);
        
        int idautopersonnel;
        
        while(resultSet.next())
        {
            Vector element = new Vector();
            idautopersonnel = resultSet.getInt(1);
            element.add(idautopersonnel);
            // Заполнение combobox'ов результатами запроса
            jcomboboxpersonnelidaddauto.addItem(resultSet.getString(1));
            jcomboboxpersonnelidchauto.addItem(resultSet.getString(1));
        }
        // Освобождение всех ресурсов
        resultSet.close();
        stmt.close();
    }
    
    // Получение уникальных id из таблицы auto
    public void getDataFromDBAutoId() throws Exception
    {
        Vector result = new Vector();
        Statement stmt =  con.createStatement();
        
        String query = "SELECT id FROM auto ORDER BY id";
        // Выполнение запроса
        ResultSet resultSet = stmt.executeQuery(query);
        
        int idauto;
        
        while(resultSet.next())
        {
            Vector element = new Vector();
            idauto = resultSet.getInt(1);
            element.add(idauto);
            // Заполнение combobox'ов результатами запроса
            jComboBoxaddjournalauto.addItem(resultSet.getString(1));
            jComboBoxchjournalauto.addItem(resultSet.getString(1));
        }
        // Освобождение всех ресурсов
        resultSet.close();
        stmt.close();
    }
    
    // Получение уникальных id и названий из таблицы routes
    public void getDataFromDBRoutes() throws Exception
    {
        Vector result = new Vector();
        Statement stmt =  con.createStatement();
        
        String query = "SELECT id, name FROM routes ORDER BY id";
        // Выполнение запроса
        ResultSet resultSet = stmt.executeQuery(query);
        
        String nameroute;
        
        while(resultSet.next())
        {
            Vector element = new Vector();
            nameroute = resultSet.getString(2);
            element.add(nameroute);
            // Заполнение combobox'ов результатами запроса
            jComboBoxaddjournalroute.addItem(resultSet.getString(1));
            jComboBoxroutes.addItem(resultSet.getString(2));
            jComboBoxchjournalroute.addItem(resultSet.getString(1));
        }
        // Освобождение всех ресурсов
        resultSet.close();
        stmt.close();
    }
    
    // Получение данных таблицы auto
    public void getDataFromDBTableAuto(String title) throws Exception
    {
        // Переменная под результат запроса
        Vector result = new Vector();
        Statement stmt =  con.createStatement();
        String query = null;
        
        if (title == "user")
        {
            query = "SELECT num, color, mark, first_name || ' ' || last_name as personnel_name FROM auto, auto_personnel WHERE (auto.personnel_id = auto_personnel.id) ORDER BY auto.id";
        }else if (title == "admin")
        {
            query = "SELECT * FROM auto ORDER BY id";
        }
        
        // Выполнение запроса
        ResultSet resultSet = stmt.executeQuery(query);
        
        int ida = 0, personnelida = 0;
        String numa = null, colora = null, marka = null, personnelname = null;
        
        // пока есть данные - выполняется цикл
        while(resultSet.next())
        {
            Vector element = new Vector();
            if (title == "admin")
            {
                ida = resultSet.getInt(1);
                numa = resultSet.getString(2);
                colora = resultSet.getString(3);
                marka = resultSet.getString(4);
                personnelida = resultSet.getInt(5);
            }else if (title == "user")
            {
                numa = resultSet.getString(1);
                colora = resultSet.getString(2);
                marka = resultSet.getString(3);
                personnelname = resultSet.getString(4);
            }
            
            if (title == "admin")
            {
                element.add(ida);
                element.add(numa);
                element.add(colora);
                element.add(marka);
                element.add(personnelida);
            }else if (title == "user")
            {
                element.add(numa);
                element.add(colora);
                element.add(marka);
                element.add(personnelname);
            }
            
            // Присоединение списока к результату
            result.add(element);
        }
        // Освобождение всех ресурсов
        resultSet.close();
        stmt.close();
        
        // "Шапка" - т.е. названия полей
        Vector headera = new Vector();
        if (title == "admin")
        {
            headera.add("id");
            headera.add("num");
            headera.add("color");
            headera.add("mark");
            headera.add("personnel_id");
        }else if (title == "user")
        {
            headera.add("num");
            headera.add("color");
            headera.add("mark");
            headera.add("personnel_name");
        }
        
        // Обновление таблицы после изменения её содержимого
        jtableauto.repaint();

        // Помещение в модель таблицы данных
        modela = (DefaultTableModel)jtableauto.getModel();
        // Сначала данные, затем шапка
        modela.setDataVector(result, headera);
        // Запрет на перемещение столбцов таблицы
        jtableauto.getTableHeader().setReorderingAllowed(false);
    }
    
    // Получение данных таблицы auto_personnel
    public void getDataFromDBTableAutoPersonnel(String title) throws Exception
    {
        // Переменная под результат запроса
        Vector resultap = new Vector();
        Statement stmtap =  con.createStatement();
        String queryap = null;
        
        if (title == "admin")
            queryap = "SELECT * FROM auto_personnel ORDER BY id";
        else if (title == "user")
            queryap = "SELECT first_name, last_name, pather_name FROM auto_personnel ORDER BY id";
        
        // Выполнение запроса
        ResultSet resultSetap = stmtap.executeQuery(queryap);
        
        int idap = 0;
        String firstname = null, lastname = null, pathername = null;
        
        while(resultSetap.next())
        {
            Vector elementap = new Vector();
            if (title == "admin")
            {
                idap = resultSetap.getInt(1);
                firstname = resultSetap.getString(2);
                lastname = resultSetap.getString(3);
                pathername = resultSetap.getString(4);
            }else if (title == "user")
            {
                firstname = resultSetap.getString(1);
                lastname = resultSetap.getString(2);
                pathername = resultSetap.getString(3);
            }

            if (title == "admin")
                elementap.add(idap);
            elementap.add(firstname);
            elementap.add(lastname);
            elementap.add(pathername);

            // Присоединение списока к результату
            resultap.add(elementap);
        }
        // Освобождение всех ресурсов
        resultSetap.close();
        stmtap.close();
        
        // "Шапка" - т.е. названия полей
        Vector headerap = new Vector();
        
        if (title == "admin")
            headerap.add("id");
        headerap.add("first name");
        headerap.add("last name");
        headerap.add("pather name");

        // Обновление таблицы после изменения её содержимого
        jtableautopersonnel.repaint();
        // Помещение в модель таблицы данных
        modelap = (DefaultTableModel)jtableautopersonnel.getModel();
        // Сначала данные, затем шапка
        modelap.setDataVector(resultap, headerap);
        // Запрет на перемещение столбцов таблицы
        jtableautopersonnel.getTableHeader().setReorderingAllowed(false);
    }
    
    // Получение данных таблицы routes
    public void getDataFromDBTableRoutes(String title) throws Exception
    {
        // Переменная под результат запроса
        Vector resultr = new Vector();
        Statement stmtr =  con.createStatement();
        String queryr = null;
        
        if (title == "admin")
        {
            queryr = "SELECT * FROM routes ORDER BY id";
        }else if (title == "user")
        {
            queryr = "SELECT name FROM routes ORDER BY id";
        }
        
        // Выполнение запроса, который в переменной query
        ResultSet resultSetr = stmtr.executeQuery(queryr);
        
        int idr = 0;
        String namer = null;
        
        while(resultSetr.next())
        {
            Vector elementr = new Vector();
            if (title == "admin")
            {
                idr = resultSetr.getInt(1);
                namer = resultSetr.getString(2);
            }else if (title == "user")
                namer = resultSetr.getString(1);
            
            if (title == "admin")
                elementr.add(idr);
            elementr.add(namer);
            
            // Присоединение списка к результату
            resultr.add(elementr);
        }
        // Освобождение всех ресурсов
        resultSetr.close();
        stmtr.close();
        
        // "Шапка" - т.е. названия полей
        Vector headerr= new Vector();
        if (title == "admin")
            headerr.add("id");
        headerr.add("name");

        // Обновление таблицы после изменения её содержимого 
        jtableroutes.repaint();
        // Помещение в модель таблицы данных
        modelr = (DefaultTableModel)jtableroutes.getModel();
        // Сначала данные, затем шапка
        modelr.setDataVector(resultr, headerr);
        // Запрет на перемещение столбцов таблицы
        jtableroutes.getTableHeader().setReorderingAllowed(false);
    }
    
    // Получение данных таблицы journal
    public void getDataFromDBTableJournal(String title) throws Exception
    {
        // Переменная под результат запроса
        Vector resultj = new Vector();
        Statement stmtj =  con.createStatement();
        String queryj = null;
        
        if (title == "admin")
            queryj = "SELECT * FROM journal ORDER BY id";
        else if (title == "user")
            queryj = "SELECT time_out, time_in, auto.mark, routes.name FROM journal, auto, routes WHERE (journal.auto_id = auto.id) AND (journal.route_id = routes.id) ORDER BY journal.id";
        
        // Выполнение запроса
        ResultSet resultSetj = stmtj.executeQuery(queryj);
        
        int idj = 0, autoidj = 0, routeidj = 0;
        String timeoutj = null, timeinj = null, automarkj = null, routenamej = null;
        
        while(resultSetj.next())
        {
            Vector elementj = new Vector();
            if (title == "admin")
            {
                idj = resultSetj.getInt(1);
                timeoutj = resultSetj.getString(2);
                if (resultSetj.getString(3) == null)
                {
                    timeinj = "null";
                }else
                {
                    timeinj = resultSetj.getString(3);
                }
                
                autoidj = resultSetj.getInt(4);
                routeidj = resultSetj.getInt(5);
            }else if (title == "user")
            {
                timeoutj = resultSetj.getString(1);
                if (resultSetj.getString(2) == null)
                {
                    timeinj = "null";
                }else
                {
                    timeinj = resultSetj.getString(2);
                }
                automarkj = resultSetj.getString(3);
                routenamej = resultSetj.getString(4);
            }
            
            if (title == "admin")
            {
                elementj.add(idj);
                elementj.add(timeoutj);
                elementj.add(timeinj);
                elementj.add(autoidj);
                elementj.add(routeidj);
            }else if (title == "user")
            {
                elementj.add(timeoutj);
                elementj.add(timeinj);
                elementj.add(automarkj);
                elementj.add(routenamej);
            }

            // Присоединение списка к результату
            resultj.add(elementj);
        }
        // Освобождение всех ресурсов
        resultSetj.close();
        stmtj.close();
       
        // "Шапка" - т.е. названия полей
        Vector headerj= new Vector();
        
        if (title == "admin")
        {
            headerj.add("id");
            headerj.add("time out");
            headerj.add("time in");
            headerj.add("auto id");
            headerj.add("route id");
        }else if (title == "user")
        {
            headerj.add("time out");
            headerj.add("time in");
            headerj.add("auto mark");
            headerj.add("route name");
        }

        // Обновление таблицы после изменения её содержимого
        jtablejournal.repaint();
        // Помещение в модель таблицы данных
        modelj = (DefaultTableModel)jtablejournal.getModel();
        // Сначала данные, затем шапка
        modelj.setDataVector(resultj, headerj);
        // Запрет на перемещение столбцов таблицы
        jtablejournal.getTableHeader().setReorderingAllowed(false);
    }
    
    // Получение результата выполнения функции
    public void getDataFromResultRecord() throws Exception
    {
        // Переменная под результат запроса
        Vector result = new Vector();
        Statement stmt =  con.createStatement();
        String query = null;
        String routename = jComboBoxroutes.getSelectedItem().toString();
        
        query = "SELECT * FROM proc_third('"+routename+"') LIMIT 1";
        
        // Выполнение запроса
        ResultSet resultSet = stmt.executeQuery(query);
        
        String interval = null, autonum = null;
        
        // пока есть данные - выполняется цикл
        while(resultSet.next())
        {
            Vector element = new Vector();
            interval = resultSet.getString(1);
            autonum = resultSet.getString(2);
            element.add(interval);
            element.add(autonum);

            // Присоединение списка к результату
            result.add(element);
        }
        // Освобождение всех ресурсов
        resultSet.close();
        stmt.close();
        
        // "Шапка" - т.е. названия полей
        Vector headera = new Vector();

        headera.add("Самое короткое время по маршруту");
        headera.add("Автомобиль");
        
        // Помещение в модель таблицы данных
        modelrecord = (DefaultTableModel)jtablerecord.getModel();
        // Сначала данные, затем шапка
        modelrecord.setDataVector(result, headera);
        jtablerecord.setVisible(true);
        jtablerecord.setShowGrid(true);
    }
    
    // Выполнение при логауте
    private void jbuttonexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonexitActionPerformed
        jpanelconnect.setVisible(true);
        jlabelmessage.setText(null);
        jlabelmessage.setVisible(false);
        jbuttonexit.setVisible(false);
        modela = (DefaultTableModel) jtableauto.getModel();
        modelap = (DefaultTableModel) jtableautopersonnel.getModel();
        modelr = (DefaultTableModel) jtableroutes.getModel();
        modelj = (DefaultTableModel) jtablejournal.getModel();
        
        jbuttonautotoexcel.setVisible(false);
        jbuttonrecordtoexcel.setVisible(false);
        jbuttonrecordtoxml.setVisible(false);
        jbuttonautopersonneltoexcel.setVisible(false);
        jbuttonroutestoexcel.setVisible(false);
        jbuttonjournaltoexcel.setVisible(false);
        
        modela.setRowCount(0);
        modelap.setRowCount(0);
        modelr.setRowCount(0);
        modelj.setRowCount(0);
        
        jformatednumadd.setText(null);
        jtextfieldcolorautoadd.setText(null);
        jtextfieldautomarkadd.setText(null);
        jcomboboxpersonnelidaddauto.setSelectedIndex(0);
        jcomboboxpersonnelidchauto.setSelectedIndex(0);
        jComboBoxroutes.setSelectedIndex(0);
        jComboBoxaddjournalauto.setSelectedIndex(0);
        jComboBoxchjournalauto.setSelectedIndex(0);
        jComboBoxaddjournalroute.setSelectedIndex(0);
        
        jcomboboxpersonnelidaddauto.removeAllItems();
        jcomboboxpersonnelidchauto.removeAllItems();
        jComboBoxroutes.removeAllItems();
        jComboBoxaddjournalauto.removeAllItems();
        jComboBoxchjournalauto.removeAllItems();
        jComboBoxaddjournalroute.removeAllItems();
        
        jtablerecord.setVisible(false);
        jtablerecord.setShowGrid(false);
        
        jSpinnersum.setValue(0);
        
        jLabelprem.setText(null);
        
        jformatednumch.setText(null);
        jtextfieldcolorautoch.setText(null);
        jtextfieldautomarkch.setText(null);
        jTextFielddelid.setText(null);
        jTextFieldfirstnameadd.setText(null);
        jTextFieldlastnameadd.setText(null);
        jTextFieldpathernameadd.setText(null);
        
        jTextFieldchfirst.setText(null);
        jTextFieldchlast.setText(null);
        jTextFieldchpather.setText(null);
        
        jTextFieldroutenameadd.setText(null);
        jTextFielddelr.setText(null);
        jTextFieldchr.setText(null);
        
        jTextFieldselectedidjournal.setText(null);
        
        titleadmin = "user";

        // Получение фокуса в окне авторизации
        jpane.setSelectedIndex(0);
        jpane.setEnabled(false);
    }//GEN-LAST:event_jbuttonexitActionPerformed

    // Выполнение при добавлении авто
    private void jButtonautoaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonautoaddActionPerformed
        if (!(jformatednumadd.getText().isEmpty()) && !(jtextfieldcolorautoadd.getText().isEmpty()) && !(jtextfieldautomarkadd.getText().isEmpty())){
                String personid = jcomboboxpersonnelidaddauto.getSelectedItem().toString();
                String mark = jtextfieldautomarkadd.getText();
                String num = jformatednumadd.getText();
                String color = jtextfieldcolorautoadd.getText();

                try {                
                    Statement stmtaddauto =  con.createStatement();
                    String queryaddauto = "INSERT INTO auto (num, color, mark, personnel_id) VALUES ('"+num+"', '"+color+"', '"+mark+"', "+personid+")";
                    
                    // Выполнение запроса
                    stmtaddauto.executeUpdate(queryaddauto);
                    JOptionPane.showMessageDialog(null, "Новый автомобиль успешно добавлен!");
                    
                    jformatednumadd.setText(null);
                    jtextfieldcolorautoadd.setText(null);
                    jtextfieldautomarkadd.setText(null);
                    stmtaddauto.close();
                    
                    jComboBoxaddjournalauto.setSelectedIndex(0);
                    jComboBoxchjournalauto.setSelectedIndex(0);
                    jComboBoxaddjournalauto.removeAllItems();
                    jComboBoxchjournalauto.removeAllItems();
                    getDataFromDBAutoId();
                    getDataFromDBTableAuto("admin");   
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Все поля должны быть заполнены!");
        }
    }//GEN-LAST:event_jButtonautoaddActionPerformed

    // Запуск функции для получения результатов выполнения функции из бд
    private void jButtonrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonrecordActionPerformed
        try {
            getDataFromResultRecord();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonrecordActionPerformed

    // Запись в xml-файл результатов
    private void jbuttonrecordtoxmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonrecordtoxmlActionPerformed
                 try {
                    DocumentBuilderFactory f = DocumentBuilderFactory
                            .newInstance();
                    DocumentBuilder builder = f.newDocumentBuilder();
                    File file = new File("results/record.xml");
 
                    if (!file.exists()) {
                        file.createNewFile();
                    }
 
                    Document doc = builder.newDocument();
                    Element tableEl = doc.createElement("table");
                    doc.appendChild(tableEl);
 
                    TableModel model = jtablerecord.getModel();
                    TableColumnModel columns = jtablerecord.getColumnModel();
 
                    for (int i = 0; i < model.getRowCount(); i++) {
                        Element rowEl = doc.createElement("row");
                        tableEl.appendChild(rowEl);
 
                        for (int j = 0; j < columns.getColumnCount(); j++) {
                            TableColumn col = columns.getColumn(j);
                            String header = col.getHeaderValue().toString();
                            String value = model.getValueAt(i, j).toString();
                            Element cellEl = doc.createElement("cell");
                            Attr colAttr = doc.createAttribute("colName");
                            cellEl.setAttributeNode(colAttr);
                            rowEl.appendChild(cellEl);
                            colAttr.appendChild(doc.createTextNode(header));
                            cellEl.appendChild(doc.createTextNode(value));
                        }
                    }
 
                    TransformerFactory tFactory = TransformerFactory
                            .newInstance();
                    Transformer transformer = tFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(file);
                    transformer.transform(source, result);
                } catch (ParserConfigurationException | IOException | DOMException | TransformerException exception) {
                    exception.printStackTrace();
                }
    }//GEN-LAST:event_jbuttonrecordtoxmlActionPerformed

    // Выполнение курсора из БД
    private void jButtonpremActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonpremActionPerformed
        // Переменная под результат запроса
        Vector result = new Vector();
        Statement stmt = null;
        
        if (jSpinnersum.getValue().toString().isEmpty() || jstart.getText().isEmpty() || jstop.getText().isEmpty())
        {
            jLabelprem.setForeground(Color.red);
            jLabelprem.setText("Следует заполнить все поля!");
        }else
        {
            try {
                stmt = con.createStatement();
                String query = null;
                String start = jstart.getText();
                String stop = jstop.getText();
                int summ = (Integer)jSpinnersum.getValue();

                query = "SELECT * FROM func3("+summ+", '"+start+"', '"+stop+"')";

                // Выполнение запроса
                ResultSet resultSet = null;
                resultSet = stmt.executeQuery(query);
                String prem = null;
                
                while(resultSet.next())
                {
                    prem = resultSet.getString(1);
                }
                
                jLabelprem.setForeground(Color.blue);
                jLabelprem.setText(prem);
                jbuttontotxt.setVisible(true);
                
                resultSet.close();
                stmt.close();
            } catch (SQLException ex) {
               Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonpremActionPerformed

    // Запись результата курсора в txt-файл
    private void jbuttontotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttontotxtActionPerformed
        try {
            saveToFile(jLabelprem.getText());
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbuttontotxtActionPerformed

    // Запись результата функции из БД в файл excell
    private void jbuttonrecordtoexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonrecordtoexcelActionPerformed
        try {
            writeToExcell(jtablerecord, "results/record.xls", "Рекордсмен");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbuttonrecordtoexcelActionPerformed

    // Запись таблицы auto в файл excell
    private void jbuttonautotoexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonautotoexcelActionPerformed
        try {
            writeToExcell(jtableauto, "results/auto.xls", "Автомобили");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbuttonautotoexcelActionPerformed

    // Запись таблицы auto_personnel в файл excell
    private void jbuttonautopersonneltoexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonautopersonneltoexcelActionPerformed
        try {
            writeToExcell(jtableautopersonnel, "results/auto_personnel.xls", "Персонал");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbuttonautopersonneltoexcelActionPerformed

    // Запись таблицы routes в файл excell
    private void jbuttonroutestoexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonroutestoexcelActionPerformed
        try {
            writeToExcell(jtableroutes, "results/routes.xls", "Маршруты");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbuttonroutestoexcelActionPerformed

    // Запись таблицы journal в файл excell
    private void jbuttonjournaltoexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonjournaltoexcelActionPerformed
        try {
            writeToExcell(jtablejournal, "results/journal.xls", "Журнал");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbuttonjournaltoexcelActionPerformed

    // Выполнение удаления выбранного auto
    private void jbuttondelautoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttondelautoActionPerformed
        if (jtextfieldselectedauto.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Сначала следует выбрать автомобиль из таблицы!");
        }else{
            String numdelauto = jtextfieldselectedauto.getText();
            try {                
                Statement stmtdelauto =  con.createStatement();
                String querydelauto = "DELETE FROM auto WHERE (num = '"+numdelauto+"')";
                // Выполнение запроса
                stmtdelauto.executeUpdate(querydelauto);
                JOptionPane.showMessageDialog(null, "Автомобиль с номером "+numdelauto+" успешно удалён!");
                jtextfieldselectedauto.setText(null);
                stmtdelauto.close();
                
                jComboBoxaddjournalauto.setSelectedIndex(0);
                jComboBoxchjournalauto.setSelectedIndex(0);
                jComboBoxaddjournalauto.removeAllItems();
                jComboBoxchjournalauto.removeAllItems();
                getDataFromDBAutoId();
                getDataFromDBTableAuto("admin");
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jbuttondelautoActionPerformed

    // Получение данных строки таблицы auto при нажатии на неё
    private void jtableautoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableautoMouseClicked
        int numselectedrow = jtableauto.getSelectedRow();
        
        if (titleadmin == "admin")
        {
            int selectedautoid = (int) jtableauto.getValueAt(numselectedrow, 0);
            String selectedautonum = (String) jtableauto.getValueAt(numselectedrow, 1);
            String selectedautocolor = (String) jtableauto.getValueAt(numselectedrow, 2);
            String selectedautomark = (String) jtableauto.getValueAt(numselectedrow, 3);
            int selectedautopersonnelid = (int) jtableauto.getValueAt(numselectedrow, 4);

            jtextfieldselectedauto.setText(selectedautonum);
            jformatednumch.setText(selectedautonum);
            jtextfieldcolorautoch.setText(selectedautocolor);
            jtextfieldautomarkch.setText(selectedautomark);
            jcomboboxpersonnelidchauto.setSelectedItem(selectedautopersonnelid);
        }  
    }//GEN-LAST:event_jtableautoMouseClicked

    // Выполнение редактирования выбранного auto
    private void jButtonautochActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonautochActionPerformed
        if (!(jformatednumch.getText().isEmpty()) && !(jtextfieldcolorautoch.getText().isEmpty()) && !(jtextfieldautomarkch.getText().isEmpty())){
            int numselectedrow = jtableauto.getSelectedRow();
            int selectedautoid = (int) jtableauto.getValueAt(numselectedrow, 0);
        
            String numchauto = jformatednumch.getText();
            String colorchauto = jtextfieldcolorautoch.getText();
            String marlchauto = jtextfieldautomarkch.getText();
            String persid = jcomboboxpersonnelidchauto.getSelectedItem().toString();
        
            try {                
                Statement stmtchauto =  con.createStatement();
                String querychauto = "UPDATE auto SET num = '"+numchauto+"', color = '"+colorchauto+"', mark = '"+marlchauto+"', personnel_id="+persid+" WHERE id="+selectedautoid;
                
                // Выполнение запроса
                stmtchauto.executeUpdate(querychauto);
                JOptionPane.showMessageDialog(null, "Автомобиль с id "+selectedautoid+" успешно изменён!");

                jformatednumch.setText(null);
                jtextfieldcolorautoch.setText(null);
                jtextfieldautomarkch.setText(null);
                jcomboboxpersonnelidchauto.setSelectedIndex(0);

                stmtchauto.close();
                jComboBoxaddjournalauto.setSelectedIndex(0);
                jComboBoxchjournalauto.setSelectedIndex(0);
                jComboBoxaddjournalauto.removeAllItems();
                jComboBoxchjournalauto.removeAllItems();
                getDataFromDBAutoId();
                getDataFromDBTableAuto("admin");
            } catch (SQLException ex) {
               Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Все поля должны быть заполнены!");
        }
    }//GEN-LAST:event_jButtonautochActionPerformed

    // Выполнение добавления auto_personnel
    private void jButtonapaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonapaddActionPerformed
        if (!(jTextFieldfirstnameadd.getText().isEmpty()) && !(jTextFieldlastnameadd.getText().isEmpty()) && !(jTextFieldpathernameadd.getText().isEmpty())){
                String firstname = jTextFieldfirstnameadd.getText();
                String lastname= jTextFieldlastnameadd.getText();
                String pathername = jTextFieldpathernameadd.getText();
                try {                
                    Statement stmtaddap =  con.createStatement();
                    String queryaddap = "INSERT INTO auto_personnel (first_name, last_name, pather_name) VALUES ('"+firstname+"', '"+lastname+"', '"+pathername+"')";
                    
                    // Выполнение запроса
                    stmtaddap.executeUpdate(queryaddap);
                    JOptionPane.showMessageDialog(null, "Новый кадр успешно добавлен!");
                    
                    jTextFieldfirstnameadd.setText(null);
                    jTextFieldlastnameadd.setText(null);
                    jTextFieldpathernameadd.setText(null);
                    stmtaddap.close();
                    jcomboboxpersonnelidaddauto.setSelectedIndex(0);
                    jcomboboxpersonnelidaddauto.removeAllItems();
                    jcomboboxpersonnelidchauto.setSelectedIndex(0);
                    jcomboboxpersonnelidchauto.removeAllItems();
                    getDataFromDBAutoPersonnelId();
                    
                    getDataFromDBTableAutoPersonnel("admin");
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Все поля должны быть заполнены!");
        }
    }//GEN-LAST:event_jButtonapaddActionPerformed

    // Получение данных строки таблицы auto_personnel при нажатии на неё
    private void jtableautopersonnelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableautopersonnelMouseClicked
        int numselectedrow = jtableautopersonnel.getSelectedRow();
        
        if (titleadmin == "admin")
        {
            int selectedapid = (int) jtableautopersonnel.getValueAt(numselectedrow, 0);
            String selectedfirst = (String) jtableautopersonnel.getValueAt(numselectedrow, 1);
            String selectedlast = (String) jtableautopersonnel.getValueAt(numselectedrow, 2);
            String selectedpather = (String) jtableautopersonnel.getValueAt(numselectedrow, 3);

            jTextFielddelid.setText(String.valueOf(selectedapid));
            jTextFieldchfirst.setText(selectedfirst);
            jTextFieldchlast.setText(selectedlast);
            jTextFieldchpather.setText(selectedpather);
        }
    }//GEN-LAST:event_jtableautopersonnelMouseClicked

    // Выполнение удаления выбранного auto_personnel
    private void jButtondelapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondelapActionPerformed
        if (jTextFielddelid.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Сначала следует выбрать кадр из таблицы!");
        }else
        {
            String apid = jTextFielddelid.getText();
            try {                
                Statement stmtdelap=  con.createStatement();
                String querydelap= "DELETE FROM auto_personnel WHERE (id = "+apid+")";
                
                // Выполнение запроса
                stmtdelap.executeUpdate(querydelap);
                JOptionPane.showMessageDialog(null, "Кадр с id = "+apid+" успешно удалён!");
                jTextFielddelid.setText(null);
                stmtdelap.close();
                
                jcomboboxpersonnelidaddauto.setSelectedIndex(0);
                jcomboboxpersonnelidaddauto.removeAllItems();
                jcomboboxpersonnelidchauto.setSelectedIndex(0);
                jcomboboxpersonnelidchauto.removeAllItems();
                getDataFromDBAutoPersonnelId();
                getDataFromDBTableAutoPersonnel("admin");
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtondelapActionPerformed

    // Выполнение редактирования выбранного auto_personnel
    private void jButtonchapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonchapActionPerformed
        if (!(jTextFieldchfirst.getText().isEmpty()) && !(jTextFieldchlast.getText().isEmpty()) && !(jTextFieldchpather.getText().isEmpty())){
                int numselectedrow = jtableautopersonnel.getSelectedRow();
                int selectedapid = (int) jtableautopersonnel.getValueAt(numselectedrow, 0);
                String first = jTextFieldchfirst.getText();
                String last = jTextFieldchlast.getText();
                String pather = jTextFieldchpather.getText();

                try {                
                    Statement stmtchap =  con.createStatement();
                    String querychap = "UPDATE auto_personnel SET first_name = '"+first+"', last_name = '"+last+"', pather_name = '"+pather+"' WHERE id="+selectedapid;
                    
                    // Выполнение запроса
                    stmtchap.executeUpdate(querychap);
                    JOptionPane.showMessageDialog(null, "Кадр с id "+selectedapid+" успешно изменён!");

                    jTextFieldchfirst.setText(null);
                    jTextFieldchlast.setText(null);
                    jTextFieldchpather.setText(null);

                    stmtchap.close();
                    
                    jcomboboxpersonnelidaddauto.setSelectedIndex(0);
                    jcomboboxpersonnelidaddauto.removeAllItems();
                    jcomboboxpersonnelidchauto.setSelectedIndex(0);
                    jcomboboxpersonnelidchauto.removeAllItems();
                    getDataFromDBAutoPersonnelId();
                    getDataFromDBTableAutoPersonnel("admin");
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else
        {
            JOptionPane.showMessageDialog(null, "Все поля должны быть заполнены!");
        }
    }//GEN-LAST:event_jButtonchapActionPerformed

    // Выполнение добавления route
    private void jButtonaddrouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaddrouteActionPerformed
        if (!(jTextFieldroutenameadd.getText().isEmpty())){
                String routename = jTextFieldroutenameadd.getText();
                try {                
                    Statement stmtaddr =  con.createStatement();
                    String queryaddr = "INSERT INTO routes (name) VALUES ('"+routename+"')";
                    
                    // Выполнение запроса
                    stmtaddr.executeUpdate(queryaddr);
                    JOptionPane.showMessageDialog(null, "Новый маршрут успешно добавлен!");
                    jTextFieldroutenameadd.setText(null);
                    stmtaddr.close();
                    
                    jComboBoxroutes.setSelectedIndex(0);
                    jComboBoxroutes.removeAllItems();
                    jComboBoxaddjournalroute.setSelectedIndex(0);
                    jComboBoxaddjournalroute.removeAllItems();
                    jComboBoxchjournalroute.setSelectedIndex(0);
                    jComboBoxchjournalroute.removeAllItems();
                    getDataFromDBRoutes();
                    getDataFromDBTableRoutes("admin");
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "Поле с названием маршрута должно быть заполнено!");
        }
    }//GEN-LAST:event_jButtonaddrouteActionPerformed

    // Получение данных строки таблицы routes при нажатии на неё
    private void jtableroutesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableroutesMouseClicked
        int numselectedrow = jtableroutes.getSelectedRow();
        
        if (titleadmin == "admin")
        {
            int selectedrid = (int) jtableroutes.getValueAt(numselectedrow, 0);
            String selectedname = (String) jtableroutes.getValueAt(numselectedrow, 1);
            jTextFielddelr.setText(String.valueOf(selectedrid));
            jTextFieldchr.setText(selectedname);
        }
    }//GEN-LAST:event_jtableroutesMouseClicked

    // Выполнение удаления выбранного route
    private void jButtondelrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondelrActionPerformed
        if (jTextFielddelr.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Сначала следует выбрать маршрут из таблицы!");
        }else
        {
            String rid = jTextFielddelr.getText();
            try {                
                Statement stmtdelr=  con.createStatement();
                String querydelr= "DELETE FROM routes WHERE (id = "+rid+")";
                
                // Выполнение запроса
                stmtdelr.executeUpdate(querydelr);
                JOptionPane.showMessageDialog(null, "Маршрут с id = "+rid+" успешно удалён!");
                jTextFielddelr.setText(null);
                stmtdelr.close();
                
                jComboBoxroutes.setSelectedIndex(0);
                jComboBoxroutes.removeAllItems();
                jComboBoxaddjournalroute.setSelectedIndex(0);
                jComboBoxaddjournalroute.removeAllItems();
                jComboBoxchjournalroute.setSelectedIndex(0);
                jComboBoxchjournalroute.removeAllItems();
                getDataFromDBRoutes();
                getDataFromDBTableRoutes("admin");
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtondelrActionPerformed

    // Выполнение редактирования выбранного route
    private void jButtonchrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonchrActionPerformed
        if (!(jTextFieldchr.getText().isEmpty())){
                int numselectedrow = jtableroutes.getSelectedRow();
                int selectedrid = (int) jtableroutes.getValueAt(numselectedrow, 0);
                String name = jTextFieldchr.getText();

                try {                
                    Statement stmtchr =  con.createStatement();
                    String querychr = "UPDATE routes SET name = '"+name+"' WHERE id="+selectedrid;
                    
                    // Выполнение запроса
                    stmtchr.executeUpdate(querychr);
                    JOptionPane.showMessageDialog(null, "Маршрут с id "+selectedrid+" успешно изменён!");
                    jTextFieldchr.setText(null);
                    stmtchr.close();
                    
                    jComboBoxroutes.setSelectedIndex(0);
                    jComboBoxroutes.removeAllItems();
                    jComboBoxaddjournalroute.setSelectedIndex(0);
                    jComboBoxchjournalroute.setSelectedIndex(0);
                    jComboBoxaddjournalroute.removeAllItems();
                    jComboBoxchjournalroute.removeAllItems();
                    getDataFromDBRoutes();
                    getDataFromDBTableRoutes("admin");
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else
        {
            JOptionPane.showMessageDialog(null, "Поле с названием марщрута должно быть заполнено!");
        }
    }//GEN-LAST:event_jButtonchrActionPerformed

    // Задаёт параметры подключения к БД
    private void jButtonsetparamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsetparamActionPerformed
        if ((!jTextFielddbname.getText().isEmpty()) && (!jTextFieldhostname.getText().isEmpty()) && (!jTextFieldport.getText().isEmpty()) && (!jTextFieldusername.getText().isEmpty()) && !(String.valueOf(jPasswordFieldpass.getPassword()).isEmpty()))
        {
            this.password = String.valueOf(jPasswordFieldpass.getPassword()); 
            this.user = jTextFieldusername.getText();
            this.url = "jdbc:postgresql://" + jTextFieldhostname.getText() + ":" + jTextFieldport.getText() + "/" + jTextFielddbname.getText();   
            jLabelerrorparamset.setForeground(Color.BLUE);
            jLabelerrorparamset.setText("Все параметры успешно заданы!");
        }else
        {
            jLabelerrorparamset.setForeground(Color.RED);
            jLabelerrorparamset.setText("Следует заполнить все поля!");
        }
    }//GEN-LAST:event_jButtonsetparamActionPerformed

    // Получение данных строки таблицы journal при нажатии на неё
    private void jtablejournalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablejournalMouseClicked
        int numselectedrow = jtablejournal.getSelectedRow();
        
        if (titleadmin == "admin")
        {
            // Получение значений выбранной строки таблицы
            int selectedjid = (int) jtablejournal.getValueAt(numselectedrow, 0);
            String selectedoutdata = (String) jtablejournal.getValueAt(numselectedrow, 1);
            String selectedindata = (String) jtablejournal.getValueAt(numselectedrow, 2);
            int selectedautoid = (int) jtablejournal.getValueAt(numselectedrow, 3);
            int selectedrouteid = (int) jtablejournal.getValueAt(numselectedrow, 4);
            
            jTextFieldselectedidjournal.setText(String.valueOf(selectedjid));
            
            // Вырезание даты и времени из поля datetime
            jFormattedTextFieldchtimeoutdate.setText(selectedoutdata.substring(0,10));
            jFormattedTextFieldchtimeouttime.setText(selectedoutdata.substring(11,19));
            
            if ((selectedindata == null) || (selectedindata == "null"))
            {
                jFormattedTextFieldchtimeindate.setText("yyyy-MM-dd");
                jFormattedTextFieldchtimeintime.setText("H:mm:ss");
            }else
            {
                jFormattedTextFieldchtimeindate.setText(selectedindata.substring(0,10));
                jFormattedTextFieldchtimeintime.setText(selectedindata.substring(11,19));
            }
            
            jComboBoxchjournalauto.setSelectedItem(selectedautoid);
            jComboBoxchjournalroute.setSelectedItem(selectedrouteid);
        }
    }//GEN-LAST:event_jtablejournalMouseClicked

    // Выполнение удаления выбранного journal
    private void jButtondeljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondeljActionPerformed
        if (jTextFieldselectedidjournal.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Сначала следует выбрать маршрут из таблицы!");
        }else
        {
            String jid = jTextFieldselectedidjournal.getText();
            try {                
                Statement stmtdelj=  con.createStatement();
                String querydelj= "DELETE FROM journal WHERE (id = "+jid+")";
                
                // Выполнение запроса
                stmtdelj.executeUpdate(querydelj);
                JOptionPane.showMessageDialog(null, "Строка журнала с id = "+jid+" успешно удалёна!");
                jTextFieldselectedidjournal.setText(null);
                stmtdelj.close();
                getDataFromDBTableJournal("admin");
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtondeljActionPerformed

    // Выполнение добавления journal
    private void jButtonaddjournalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaddjournalActionPerformed
        if (!(jFormattedTextFieldtimeoutadddata.getText().isEmpty()) && !(jFormattedTextFieldaddtimeouttime.getText().isEmpty()) && !(jFormattedTextFieldtimeinadddata.getText().isEmpty()) && !(jFormattedTextFieldaddtimeintime.getText().isEmpty()))
        {
                String timeoutdata = jFormattedTextFieldtimeoutadddata.getText();
                String timeouttime= jFormattedTextFieldaddtimeouttime.getText();
                String timeindata = jFormattedTextFieldtimeinadddata.getText();
                String timeintime = jFormattedTextFieldaddtimeintime.getText();
                String autoid = jComboBoxaddjournalauto.getSelectedItem().toString();
                String routeid = jComboBoxaddjournalroute.getSelectedItem().toString();
                
                if (!(timeoutdata.equals("yyyy-MM-dd")) && !(timeouttime.equals("H:mm:ss")) && !(timeindata.equals("yyyy-MM-dd")) && !(timeintime.equals("H:mm:ss")))
                {
                    try {                
                    Statement stmtaddj =  con.createStatement();
                    String queryaddj = "INSERT INTO journal (time_out, time_in, auto_id, route_id) VALUES ('"+timeoutdata + ' ' + timeouttime+"', '"+timeindata + ' ' + timeintime+"', "+autoid+", "+routeid+")";
                    // Выполнение запроса
                    stmtaddj.executeUpdate(queryaddj);
                    JOptionPane.showMessageDialog(null, "Новая запись успешно добавлена!");
                    
                    jFormattedTextFieldtimeoutadddata.setText("yyyy-MM-dd");
                    jFormattedTextFieldaddtimeouttime.setText("yyyy-MM-dd");
                    jFormattedTextFieldtimeinadddata.setText("H:mm:ss");
                    jFormattedTextFieldaddtimeintime.setText("H:mm:ss");
                            
                    stmtaddj.close();
                    
                    getDataFromDBTableJournal("admin");
                    } catch (SQLException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else
                {
                    JOptionPane.showMessageDialog(null, "Все поля должны быть заполнены!");
                }
        }else
        {
            JOptionPane.showMessageDialog(null, "Все поля должны быть заполнены!");
        }
    }//GEN-LAST:event_jButtonaddjournalActionPerformed

    // Выполнение редактирования выбранного journal
    private void jButtonchjournalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonchjournalActionPerformed
        if (!(jFormattedTextFieldchtimeoutdate.getText().isEmpty()) && !(jFormattedTextFieldchtimeindate.getText().isEmpty()) && !(jFormattedTextFieldchtimeouttime.getText().isEmpty()) && !(jFormattedTextFieldchtimeintime.getText().isEmpty()) 
                && !(jFormattedTextFieldchtimeoutdate.getText().equals("yyyy-MM-dd")) && !(jFormattedTextFieldchtimeouttime.getText().equals("H:mm:ss")))
        {
                int numselectedrow = jtablejournal.getSelectedRow();
                int selectedjid = (int) jtablejournal.getValueAt(numselectedrow, 0);
                String timeindate = jFormattedTextFieldchtimeindate.getText();
                String timeintime = jFormattedTextFieldchtimeintime.getText();
                String timeoutdate = jFormattedTextFieldchtimeoutdate.getText();
                String timeouttime = jFormattedTextFieldchtimeouttime.getText();
                String autoid = jComboBoxchjournalauto.getSelectedItem().toString();
                String routeid = jComboBoxchjournalroute.getSelectedItem().toString();

                try {                
                    Statement stmtchj =  con.createStatement();
                    String querychj = "UPDATE journal SET time_out = '"+(timeoutdate+' '+timeouttime)+"', time_in = '"+(timeindate+' '+timeintime)+"', auto_id = "+autoid+", route_id = "+routeid+" WHERE id="+selectedjid;
                    
                    // Выполнение запроса
                    stmtchj.executeUpdate(querychj);
                    JOptionPane.showMessageDialog(null, "Строка журнала с id "+selectedjid+" успешно изменёна!");

                    jFormattedTextFieldchtimeoutdate.setText("yyyy-MM-dd");
                    jFormattedTextFieldchtimeindate.setText("yyyy-MM-dd");
                    jFormattedTextFieldchtimeouttime.setText("H:mm:ss");
                    jFormattedTextFieldchtimeintime.setText("H:mm:ss");

                    stmtchj.close();
                    
                    getDataFromDBTableJournal("admin");
                } catch (SQLException ex) {
                   // Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                //Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
        }else
        {
            JOptionPane.showMessageDialog(null, "Все поля должны быть заполнены!");
        }
    }//GEN-LAST:event_jButtonchjournalActionPerformed

    // Запись данных таблиц в файл excell
    private static void writeToExcell(JTable table, String path, String sheetname) throws FileNotFoundException, IOException 
    {
        HSSFWorkbook bk = new  HSSFWorkbook ();
        HSSFSheet sh = bk.createSheet(sheetname);
        TableModel model;
        model = table.getModel();
        TableColumnModel tcm = table.getColumnModel();
        HSSFRow rw = sh.createRow ((short) 0);
        
        for(int j = 0; j < tcm.getColumnCount(); j++) 
        {     
            HSSFCell cl = rw.createCell ((short) j);
            cl.setCellValue(tcm.getColumn(j).getHeaderValue().toString());
        }
        
        for (int i = 0; i < model.getRowCount(); i++) 
        {
            HSSFRow fRow = sh.createRow((short) i+1);
            for (int j = 0; j < model.getColumnCount(); j++) 
            {
                HSSFCell cell = fRow.createCell((short) j);
                if ((model.getValueAt(i, j).toString() == null))
                {
                    System.out.println("1");
                    String nullString = null;
                    cell.setCellValue(nullString);
                }else
                {
                    cell.setCellValue(model.getValueAt(i, j).toString());
                }
            }
            FileOutputStream fl = null;
            try {
                fl = new FileOutputStream(path);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (BufferedOutputStream bos = new BufferedOutputStream(fl)) {
              try {
                bk.write(bos);
              } catch (IOException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
              }
            } catch (IOException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fl.close();
            } catch (IOException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }             
    }
    
    // Запись результата курсора из БД в txt-файл
    static void saveToFile(String text) throws IOException 
    {
        File f = new File("results/премии.txt");
        System.out.println(f);
        FileWriter fw = new FileWriter(f,true);
        System.out.println(fw);
        try{
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println(bw);
            bw.newLine();
            bw.write(text);
            bw.flush();
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonaddjournal;
    private javax.swing.JButton jButtonaddroute;
    private javax.swing.JButton jButtonapadd;
    private javax.swing.JButton jButtonautoadd;
    private javax.swing.JButton jButtonautoch;
    private javax.swing.JButton jButtonchap;
    private javax.swing.JButton jButtonchjournal;
    private javax.swing.JButton jButtonchr;
    private javax.swing.JButton jButtondelap;
    private javax.swing.JButton jButtondelj;
    private javax.swing.JButton jButtondelr;
    private javax.swing.JButton jButtonprem;
    private javax.swing.JButton jButtonrecord;
    private javax.swing.JButton jButtonsetparam;
    private javax.swing.JComboBox jComboBoxaddjournalauto;
    private javax.swing.JComboBox jComboBoxaddjournalroute;
    private javax.swing.JComboBox jComboBoxchjournalauto;
    private javax.swing.JComboBox jComboBoxchjournalroute;
    private javax.swing.JComboBox<String> jComboBoxroutes;
    private javax.swing.JFormattedTextField jFormattedTextFieldaddtimeintime;
    private javax.swing.JFormattedTextField jFormattedTextFieldaddtimeouttime;
    private javax.swing.JFormattedTextField jFormattedTextFieldchtimeindate;
    private javax.swing.JFormattedTextField jFormattedTextFieldchtimeintime;
    private javax.swing.JFormattedTextField jFormattedTextFieldchtimeoutdate;
    private javax.swing.JFormattedTextField jFormattedTextFieldchtimeouttime;
    private javax.swing.JFormattedTextField jFormattedTextFieldtimeinadddata;
    private javax.swing.JFormattedTextField jFormattedTextFieldtimeoutadddata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabeladdautomark;
    private javax.swing.JLabel jLabeladdautomark1;
    private javax.swing.JLabel jLabeladdpersonnelidauto;
    private javax.swing.JLabel jLabeladdpersonnelidauto1;
    private javax.swing.JLabel jLabelerrorparamset;
    private javax.swing.JLabel jLabelinforecord;
    private javax.swing.JLabel jLabelprem;
    private javax.swing.JLabel jLabelroutename;
    private javax.swing.JPanel jPaneladdjournal;
    private javax.swing.JPanel jPaneladdroute;
    private javax.swing.JPanel jPanelapadd;
    private javax.swing.JPanel jPanelapch;
    private javax.swing.JPanel jPanelauto;
    private javax.swing.JPanel jPanelautoadd;
    private javax.swing.JPanel jPanelchr;
    private javax.swing.JPanel jPanelcoursor;
    private javax.swing.JPanel jPaneldelap;
    private javax.swing.JPanel jPaneldelr;
    private javax.swing.JPanel jPaneljournalch;
    private javax.swing.JPanel jPaneljournaldel;
    private javax.swing.JPasswordField jPasswordFieldpass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinnersum;
    private javax.swing.JTabbedPane jTabbedPaneautopers;
    private javax.swing.JTabbedPane jTabbedPanejournal;
    private javax.swing.JTabbedPane jTabbedPaneroutes;
    private javax.swing.JTextArea jTextAreacoursor;
    private javax.swing.JTextField jTextFieldchfirst;
    private javax.swing.JTextField jTextFieldchlast;
    private javax.swing.JTextField jTextFieldchpather;
    private javax.swing.JTextField jTextFieldchr;
    private javax.swing.JTextField jTextFielddbname;
    private javax.swing.JTextField jTextFielddelid;
    private javax.swing.JTextField jTextFielddelr;
    private javax.swing.JTextField jTextFieldfirstnameadd;
    private javax.swing.JTextField jTextFieldhostname;
    private javax.swing.JTextField jTextFieldlastnameadd;
    private javax.swing.JTextField jTextFieldpathernameadd;
    private javax.swing.JTextField jTextFieldport;
    private javax.swing.JTextField jTextFieldroutenameadd;
    private javax.swing.JTextField jTextFieldselectedidjournal;
    private javax.swing.JTextField jTextFieldusername;
    private javax.swing.JButton jbuttonauth;
    private javax.swing.JButton jbuttonautopersonneltoexcel;
    private javax.swing.JButton jbuttonautotoexcel;
    private javax.swing.JButton jbuttondelauto;
    private javax.swing.JButton jbuttonexit;
    private javax.swing.JButton jbuttonjournaltoexcel;
    private javax.swing.JButton jbuttonrecordtoexcel;
    private javax.swing.JButton jbuttonrecordtoxml;
    private javax.swing.JButton jbuttonroutestoexcel;
    private javax.swing.JButton jbuttontestconnection;
    private javax.swing.JButton jbuttontotxt;
    private javax.swing.JComboBox<String> jcomboboxpersonnelidaddauto;
    private javax.swing.JComboBox<String> jcomboboxpersonnelidchauto;
    private javax.swing.JFormattedTextField jformatednumadd;
    private javax.swing.JFormattedTextField jformatednumch;
    private javax.swing.JLabel jlabelcoloradd;
    private javax.swing.JLabel jlabelcoloradd1;
    public javax.swing.JLabel jlabelconnect;
    private javax.swing.JLabel jlabelerror;
    public javax.swing.JLabel jlabelmessage;
    private javax.swing.JLabel jlabelpass;
    private javax.swing.JLabel jlabelusername;
    private javax.swing.JTextField jloginfield;
    private javax.swing.JTabbedPane jpane;
    public javax.swing.JPanel jpaneauto;
    private javax.swing.JTabbedPane jpaneautoadd;
    private javax.swing.JPanel jpaneautochange;
    private javax.swing.JPanel jpaneautodel;
    public javax.swing.JPanel jpaneautopersonnel;
    public javax.swing.JPanel jpaneconnect;
    public javax.swing.JPanel jpanejournal;
    private javax.swing.JTabbedPane jpanelauth;
    private javax.swing.JPanel jpanelconnect;
    private javax.swing.JPanel jpanelparamconnection;
    private javax.swing.JPanel jpanelrecord;
    public javax.swing.JPanel jpaneroutes;
    private javax.swing.JPasswordField jpasswordfield;
    private javax.swing.JFormattedTextField jstart;
    private javax.swing.JFormattedTextField jstop;
    public javax.swing.JTable jtableauto;
    public javax.swing.JTable jtableautopersonnel;
    public javax.swing.JTable jtablejournal;
    private javax.swing.JTable jtablerecord;
    public javax.swing.JTable jtableroutes;
    private javax.swing.JTextField jtextfieldautomarkadd;
    private javax.swing.JTextField jtextfieldautomarkch;
    private javax.swing.JTextField jtextfieldcolorautoadd;
    private javax.swing.JTextField jtextfieldcolorautoch;
    private javax.swing.JTextField jtextfieldselectedauto;
    // End of variables declaration//GEN-END:variables
}