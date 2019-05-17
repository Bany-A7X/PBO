
package tubespbo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import AppPackage.AnimationClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dashboard extends javax.swing.JFrame {
    int mouseX, mouseY;
    String nama,email,kategori,item,lokasi,keterangan;
    int nim;
    private DefaultTableModel model;

    public void loaddata(){
        nim = Integer.parseInt(text_nim.getText());
        nama = text_nama.getText();
        email =text_email.getText();
        kategori = (String)cb_kategori.getSelectedItem();
        item = (String)cb_item.getSelectedItem();
        lokasi = (String)cb_lokasi.getSelectedItem();
        keterangan = (String)Cb_keterangan.getSelectedItem();
    }
    
    
    public void saveData(){
        loaddata();
        try{
        Statement stat = (Statement) koneksi.getKoneksi().createStatement();
        keterangan = "belum";
        String sql = "Insert into menuadd (id,nama,email,kategori,item,lokasi,keterangan)"
                    +"values ('"+nim+"','"+nama+"','"+email+"','"+kategori+"',"
                    +"'"+item+"','"+lokasi+"','"+keterangan+"')";
        PreparedStatement p = (PreparedStatement) koneksi.getKoneksi().prepareStatement(sql);
        p.executeUpdate();
        JOptionPane.showMessageDialog(null,"Berhasil!");
        }catch(SQLException x){
            JOptionPane.showMessageDialog(null,"Tidak diterima!",". Harap coba kembali.",2);
    /**
     * Creates new form dashboard
     */
        }
    }
        
        
        //menampilkan data dari  database pada tabel
    private void load_table(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NO");
        model.addColumn("NIM/NIP");
        model.addColumn("Nama");
        model.addColumn("Email");
        model.addColumn("Kategori");
        model.addColumn("Item");
        model.addColumn("Lokasi");
        model.addColumn("Keterangan");
        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from menuadd WHERE keterangan IN ('belum','diproses')";
            Connection conn=(Connection)koneksi.getKoneksi();
            Statement stm=conn.createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
            }
            tabel_edit.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void load_table1(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NO");
        model.addColumn("NIM/NIP");
        model.addColumn("Nama");
        model.addColumn("Email");
        model.addColumn("Kategori");
        model.addColumn("Item");
        model.addColumn("Lokasi");
        model.addColumn("Keterangan");
        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String Sql = "select * from menuadd WHERE keterangan ='selesai'";
            Connection conn=(Connection)koneksi.getKoneksi();
            Statement stm=conn.createStatement();
            ResultSet res=stm.executeQuery(Sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
            }
            tabel_histori.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void kosong(){
        text_nama.setText(null);
        text_nim.setText(null);
        text_email.setText(null);
        cb_kategori.setSelectedItem("Kategori");
        cb_item.setSelectedItem("Item");
        cb_lokasi.setSelectedItem("Lokasi");
        
        show_id.setText(null);
        show_nama.setText(null);
        show_email.setText(null);
        cb_kategori1.setSelectedItem(null);
        cb_item1.setSelectedItem(null);
        cb_lokasi1.setSelectedItem(null);
        Cb_keterangan.setSelectedItem(null);
    }
    
    private void edit() {                                         
        // Edit Data
        try {
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            String sql ="UPDATE menuadd SET id = '"+show_id.getText()+"', nama = '"+show_nama.getText()+
                    "', email = '"+show_email.getText()+"', kategori = '"+cb_kategori1.getSelectedItem()+
                    "', item = '"+cb_item1.getSelectedItem()+"', lokasi = '"+cb_lokasi1.getSelectedItem()+"', keterangan = '"+
                    Cb_keterangan.getSelectedItem()+"' WHERE id = '"+show_id.getText()+"'";
            
            Connection conn=(Connection)koneksi.getKoneksi();
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal. "+e.getMessage());
        }
        load_table();
        kosong();
    }
        
        
    
    public dashboard() {
        initComponents();
        showDate();
        this.setLocationRelativeTo(null);
    }
    
    void showDate(){
        Date d = new Date();
        SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyy");
        date1.setText(s.format(d));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu_label = new javax.swing.JPanel();
        home_panel = new javax.swing.JPanel();
        garis1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        add_panel = new javax.swing.JPanel();
        garis2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        edit_panel = new javax.swing.JPanel();
        garis3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        histori_panel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        garis4 = new javax.swing.JPanel();
        kepala = new javax.swing.JPanel();
        label_judultubes = new javax.swing.JLabel();
        logoclose = new javax.swing.JLabel();
        logominimize = new javax.swing.JLabel();
        cardlayout = new javax.swing.JPanel();
        home_konten = new javax.swing.JPanel();
        label_admin = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jLabel7 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        Mail = new javax.swing.JLabel();
        konten_home = new javax.swing.JPanel();
        icon_back = new javax.swing.JButton();
        icon_next = new javax.swing.JButton();
        background_home = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();
        add_konten = new javax.swing.JPanel();
        gbr_nim = new javax.swing.JLabel();
        text_nim = new javax.swing.JTextField();
        label_nim = new javax.swing.JLabel();
        gbr_nama = new javax.swing.JLabel();
        label_nama = new javax.swing.JLabel();
        text_nama = new javax.swing.JTextField();
        gbr_kategori = new javax.swing.JLabel();
        text_email = new javax.swing.JTextField();
        gbr_email = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        gbr_lokasi = new javax.swing.JLabel();
        label_kerusakan = new javax.swing.JLabel();
        cb_kategori = new javax.swing.JComboBox<>();
        gbr_kerusakan = new javax.swing.JLabel();
        cb_lokasi = new javax.swing.JComboBox<>();
        gbr_item = new javax.swing.JLabel();
        cb_item = new javax.swing.JComboBox<>();
        save = new java.awt.Button();
        wallpaper_konten_add = new javax.swing.JLabel();
        edit_konten = new javax.swing.JPanel();
        tabel_panel1 = new javax.swing.JScrollPane();
        tabel_edit = new javax.swing.JTable();
        show_nama = new javax.swing.JTextField();
        show_email = new javax.swing.JTextField();
        show_id = new javax.swing.JTextField();
        gbr_nama1 = new javax.swing.JLabel();
        gbr_email1 = new javax.swing.JLabel();
        gbr_kerusakan1 = new javax.swing.JLabel();
        bt_save = new javax.swing.JButton();
        gbr_kategori1 = new javax.swing.JLabel();
        cb_kategori1 = new javax.swing.JComboBox<>();
        gbr_item1 = new javax.swing.JLabel();
        cb_item1 = new javax.swing.JComboBox<>();
        label_kerusakan1 = new javax.swing.JLabel();
        gbr_lokasi1 = new javax.swing.JLabel();
        cb_lokasi1 = new javax.swing.JComboBox<>();
        Cb_keterangan = new javax.swing.JComboBox<>();
        gbr_lokasi2 = new javax.swing.JLabel();
        gbr_nim1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        histori_konten = new javax.swing.JPanel();
        tabel_panel2 = new javax.swing.JScrollPane();
        tabel_histori = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu_label.setBackground(new java.awt.Color(23, 35, 51));

        home_panel.setBackground(new java.awt.Color(23, 35, 51));
        home_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                home_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                home_panelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                home_panelMousePressed(evt);
            }
        });

        garis1.setOpaque(false);

        javax.swing.GroupLayout garis1Layout = new javax.swing.GroupLayout(garis1);
        garis1.setLayout(garis1Layout);
        garis1Layout.setHorizontalGroup(
            garis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        garis1Layout.setVerticalGroup(
            garis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/home_50px.png"))); // NOI18N

        javax.swing.GroupLayout home_panelLayout = new javax.swing.GroupLayout(home_panel);
        home_panel.setLayout(home_panelLayout);
        home_panelLayout.setHorizontalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_panelLayout.createSequentialGroup()
                .addComponent(garis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        home_panelLayout.setVerticalGroup(
            home_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(garis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel8)
        );

        add_panel.setBackground(new java.awt.Color(23, 35, 51));
        add_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_panelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_panelMousePressed(evt);
            }
        });

        garis2.setOpaque(false);

        javax.swing.GroupLayout garis2Layout = new javax.swing.GroupLayout(garis2);
        garis2.setLayout(garis2Layout);
        garis2Layout.setHorizontalGroup(
            garis2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        garis2Layout.setVerticalGroup(
            garis2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/add_50px.png"))); // NOI18N

        javax.swing.GroupLayout add_panelLayout = new javax.swing.GroupLayout(add_panel);
        add_panel.setLayout(add_panelLayout);
        add_panelLayout.setHorizontalGroup(
            add_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_panelLayout.createSequentialGroup()
                .addComponent(garis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        add_panelLayout.setVerticalGroup(
            add_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(garis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel9)
        );

        edit_panel.setBackground(new java.awt.Color(23, 35, 51));
        edit_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_panelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                edit_panelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit_panelMousePressed(evt);
            }
        });

        garis3.setOpaque(false);

        javax.swing.GroupLayout garis3Layout = new javax.swing.GroupLayout(garis3);
        garis3.setLayout(garis3Layout);
        garis3Layout.setHorizontalGroup(
            garis3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        garis3Layout.setVerticalGroup(
            garis3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/edit_50px.png"))); // NOI18N

        javax.swing.GroupLayout edit_panelLayout = new javax.swing.GroupLayout(edit_panel);
        edit_panel.setLayout(edit_panelLayout);
        edit_panelLayout.setHorizontalGroup(
            edit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edit_panelLayout.createSequentialGroup()
                .addComponent(garis3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        edit_panelLayout.setVerticalGroup(
            edit_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(garis3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel10)
        );

        histori_panel.setBackground(new java.awt.Color(23, 35, 51));
        histori_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histori_panelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                histori_panelMousePressed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/clock_filled_50px.png"))); // NOI18N

        garis4.setOpaque(false);

        javax.swing.GroupLayout garis4Layout = new javax.swing.GroupLayout(garis4);
        garis4.setLayout(garis4Layout);
        garis4Layout.setHorizontalGroup(
            garis4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        garis4Layout.setVerticalGroup(
            garis4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout histori_panelLayout = new javax.swing.GroupLayout(histori_panel);
        histori_panel.setLayout(histori_panelLayout);
        histori_panelLayout.setHorizontalGroup(
            histori_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, histori_panelLayout.createSequentialGroup()
                .addComponent(garis4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(24, 24, 24))
        );
        histori_panelLayout.setVerticalGroup(
            histori_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, histori_panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(histori_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(garis4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)))
        );

        javax.swing.GroupLayout menu_labelLayout = new javax.swing.GroupLayout(menu_label);
        menu_label.setLayout(menu_labelLayout);
        menu_labelLayout.setHorizontalGroup(
            menu_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(add_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(edit_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(histori_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menu_labelLayout.setVerticalGroup(
            menu_labelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu_labelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(home_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(add_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(edit_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(histori_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        getContentPane().add(menu_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 630));

        kepala.setBackground(new java.awt.Color(71, 120, 197));

        label_judultubes.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        label_judultubes.setForeground(new java.awt.Color(255, 255, 255));
        label_judultubes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_judultubes.setText("Layanan Informasi Pengaduan Kerusakan Fasilitas ");
        label_judultubes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                label_judultubesMouseDragged(evt);
            }
        });
        label_judultubes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_judultubesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                label_judultubesMouseReleased(evt);
            }
        });

        logoclose.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        logoclose.setForeground(new java.awt.Color(255, 255, 255));
        logoclose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoclose.setText("X");
        logoclose.setFocusable(false);
        logoclose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logocloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logocloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logocloseMouseExited(evt);
            }
        });

        logominimize.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        logominimize.setForeground(new java.awt.Color(255, 255, 255));
        logominimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logominimize.setText("-");
        logominimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logominimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logominimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logominimizeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout kepalaLayout = new javax.swing.GroupLayout(kepala);
        kepala.setLayout(kepalaLayout);
        kepalaLayout.setHorizontalGroup(
            kepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kepalaLayout.createSequentialGroup()
                .addContainerGap(1098, Short.MAX_VALUE)
                .addComponent(logominimize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(logoclose, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(kepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(label_judultubes, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE))
        );
        kepalaLayout.setVerticalGroup(
            kepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kepalaLayout.createSequentialGroup()
                .addGroup(kepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logominimize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kepalaLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(logoclose, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(kepalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kepalaLayout.createSequentialGroup()
                    .addComponent(label_judultubes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        getContentPane().add(kepala, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 1160, 40));

        cardlayout.setLayout(new java.awt.CardLayout());

        label_admin.setBackground(new java.awt.Color(71, 120, 197));

        jPanel5.setBackground(new java.awt.Color(120, 168, 252));

        jPanel6.setBackground(new java.awt.Color(84, 127, 206));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INSTITUT TEKNOLOGI SUMATERA");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/rsz_logo_itera_oke.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/export_26px.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/administrator_male_60px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ADMINISTRATOR");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 60)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("17");

        button1.setBackground(new java.awt.Color(71, 120, 197));
        button1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("ANGKATAN");
        button1.setName(""); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/overtime_40px.png"))); // NOI18N

        date1.setForeground(new java.awt.Color(255, 255, 255));

        Mail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/filled_message_48px.png"))); // NOI18N
        Mail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout label_adminLayout = new javax.swing.GroupLayout(label_admin);
        label_admin.setLayout(label_adminLayout);
        label_adminLayout.setHorizontalGroup(
            label_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(label_adminLayout.createSequentialGroup()
                .addGroup(label_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(label_adminLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(label_adminLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(label_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Mail)
                            .addGroup(label_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(label_adminLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel6)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        label_adminLayout.setVerticalGroup(
            label_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(label_adminLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(label_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        konten_home.setBackground(new java.awt.Color(255, 255, 255));
        konten_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/circled_chevron_left_40px.png"))); // NOI18N
        icon_back.setContentAreaFilled(false);
        icon_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_backMouseClicked(evt);
            }
        });
        konten_home.add(icon_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 40, -1));

        icon_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/circled_chevron_right_40px.png"))); // NOI18N
        icon_next.setContentAreaFilled(false);
        icon_next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_nextMouseClicked(evt);
            }
        });
        konten_home.add(icon_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 540, 40, -1));

        background_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/wallpaper 4.jpg"))); // NOI18N
        konten_home.add(background_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 590));

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/wallpaper 3.jpg"))); // NOI18N
        konten_home.add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 810, 590));

        javax.swing.GroupLayout home_kontenLayout = new javax.swing.GroupLayout(home_konten);
        home_konten.setLayout(home_kontenLayout);
        home_kontenLayout.setHorizontalGroup(
            home_kontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(home_kontenLayout.createSequentialGroup()
                .addComponent(label_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(konten_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        home_kontenLayout.setVerticalGroup(
            home_kontenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(konten_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardlayout.add(home_konten, "card2");

        add_konten.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gbr_nim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/id_card_40px.png"))); // NOI18N
        add_konten.add(gbr_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 30));

        text_nim.setBackground(javax.swing.UIManager.getDefaults().getColor("FormattedTextField.inactiveBackground"));
        text_nim.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        text_nim.setBorder(null);
        add_konten.add(text_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 510, 30));

        label_nim.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        label_nim.setForeground(new java.awt.Color(255, 255, 255));
        label_nim.setText("NIM/NIP          :");
        add_konten.add(label_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 30));

        gbr_nama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/user_40px.png"))); // NOI18N
        add_konten.add(gbr_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, 30));

        label_nama.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        label_nama.setForeground(new java.awt.Color(255, 255, 255));
        label_nama.setText("NAMA             :");
        add_konten.add(label_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, 30));

        text_nama.setBackground(javax.swing.UIManager.getDefaults().getColor("FormattedTextField.inactiveBackground"));
        text_nama.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        text_nama.setBorder(null);
        add_konten.add(text_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 510, 30));

        gbr_kategori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/category_40px.png"))); // NOI18N
        add_konten.add(gbr_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, 30));

        text_email.setBackground(javax.swing.UIManager.getDefaults().getColor("FormattedTextField.inactiveBackground"));
        text_email.setFont(new java.awt.Font("Sylfaen", 0, 25)); // NOI18N
        text_email.setBorder(null);
        add_konten.add(text_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 510, 30));

        gbr_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/message_filled_40px.png"))); // NOI18N
        add_konten.add(gbr_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, 30));

        label_email.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        label_email.setForeground(new java.awt.Color(255, 255, 255));
        label_email.setText("E-MAIL           :");
        add_konten.add(label_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, 30));

        gbr_lokasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/marker_40px.png"))); // NOI18N
        add_konten.add(gbr_lokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, -1, -1));

        label_kerusakan.setFont(new java.awt.Font("Sylfaen", 1, 25)); // NOI18N
        label_kerusakan.setForeground(new java.awt.Color(255, 255, 255));
        label_kerusakan.setText("KERUSAKAN  :");
        add_konten.add(label_kerusakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, 30));

        cb_kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KATEGORI", "sarana/prasarana" }));
        add_konten.add(cb_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, -1, -1));

        gbr_kerusakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/factory_breakdown_40px.png"))); // NOI18N
        add_konten.add(gbr_kerusakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, 30));

        cb_lokasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gedung C", "C101", "C102", "C103", "C104", "C105", "C106", "C107", "C108", "C109", "C110", "C111", "C112", "C113" }));
        add_konten.add(cb_lokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, -1, 30));

        gbr_item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/product_40px.png"))); // NOI18N
        add_konten.add(gbr_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, -1, 30));

        cb_item.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ITEM", "Kipas", "AC", "Proyektor", "Papan tulis", "Meja", "Kursi" }));
        add_konten.add(cb_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, -1, 30));

        save.setLabel("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        add_konten.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, 60, -1));

        wallpaper_konten_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/rsz_industrial-hall-1630740_1920-e1507904049620.jpg"))); // NOI18N
        add_konten.add(wallpaper_konten_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, -1));

        cardlayout.add(add_konten, "card3");

        edit_konten.setBackground(new java.awt.Color(255, 255, 255));
        edit_konten.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel_edit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIM/NIP", "Nama", "Email", "Kategori", "Item", "Lokasi", "Keterangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabel_edit.setColumnSelectionAllowed(true);
        tabel_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_editMouseClicked(evt);
            }
        });
        tabel_panel1.setViewportView(tabel_edit);

        edit_konten.add(tabel_panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 870, 520));

        show_nama.setBackground(javax.swing.UIManager.getDefaults().getColor("FormattedTextField.inactiveBackground"));
        show_nama.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        show_nama.setBorder(null);
        edit_konten.add(show_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 160, 30));

        show_email.setBackground(javax.swing.UIManager.getDefaults().getColor("FormattedTextField.inactiveBackground"));
        show_email.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        show_email.setBorder(null);
        edit_konten.add(show_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 160, 30));

        show_id.setBackground(javax.swing.UIManager.getDefaults().getColor("FormattedTextField.inactiveBackground"));
        show_id.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        show_id.setBorder(null);
        edit_konten.add(show_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 160, 30));

        gbr_nama1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/user_40px.png"))); // NOI18N
        edit_konten.add(gbr_nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        gbr_email1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/message_filled_40px.png"))); // NOI18N
        edit_konten.add(gbr_email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        gbr_kerusakan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/factory_breakdown_40px.png"))); // NOI18N
        edit_konten.add(gbr_kerusakan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 30));

        bt_save.setText("save");
        bt_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bt_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bt_saveMouseExited(evt);
            }
        });
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });
        edit_konten.add(bt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, -1, -1));

        gbr_kategori1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/category_40px.png"))); // NOI18N
        edit_konten.add(gbr_kategori1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, 30));

        cb_kategori1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KATEGORI", "sarana/prasarana" }));
        edit_konten.add(cb_kategori1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        gbr_item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/product_40px.png"))); // NOI18N
        edit_konten.add(gbr_item1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, 30));

        cb_item1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ITEM", "Kipas", "AC", "Proyektor", "Papan tulis", "Meja", "Kursi" }));
        edit_konten.add(cb_item1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, 30));

        label_kerusakan1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        label_kerusakan1.setForeground(new java.awt.Color(255, 255, 255));
        label_kerusakan1.setText("KERUSAKAN  :");
        edit_konten.add(label_kerusakan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, 30));
        edit_konten.add(gbr_lokasi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 30, 40));

        cb_lokasi1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gedung C", "C101", "C102", "C103", "C104", "C105", "C106", "C107", "C108", "C109", "C110", "C111", "C112", "C113" }));
        edit_konten.add(cb_lokasi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, 30));

        Cb_keterangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Keterangan", "belum", "diproses", "selesai" }));
        Cb_keterangan.setName(""); // NOI18N
        edit_konten.add(Cb_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, 30));

        gbr_lokasi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/marker_40px.png"))); // NOI18N
        edit_konten.add(gbr_lokasi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        gbr_nim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/id_card_40px.png"))); // NOI18N
        edit_konten.add(gbr_nim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/rsz_warehouse (1).jpg"))); // NOI18N
        edit_konten.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 590));

        cardlayout.add(edit_konten, "card4");

        histori_konten.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel_histori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIM/NIP", "Nama", "Email", "Kategori", "Item", "Lokasi", "Keterangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabel_histori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_historiMouseClicked(evt);
            }
        });
        tabel_panel2.setViewportView(tabel_histori);

        histori_konten.add(tabel_panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 1000, 520));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tubespbo/images/histori.jpg"))); // NOI18N
        histori_konten.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        cardlayout.add(histori_konten, "card5");

        getContentPane().add(cardlayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 1160, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void label_judultubesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_judultubesMousePressed
        // TODO add your handling code here:
        mouseX= evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_label_judultubesMousePressed

    private void label_judultubesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_judultubesMouseDragged
        // TODO add your handling code here: untuk dapat mendrag form login
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();
        this.setOpacity(0.9f);
        this.setLocation(kordinatX-mouseX, kordinatY-mouseY); //dapat mengklik drag dimanaput posisi kursornya
    }//GEN-LAST:event_label_judultubesMouseDragged

    private void logocloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logocloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);

    }//GEN-LAST:event_logocloseMouseClicked

    private void logocloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logocloseMouseEntered
        // TODO add your handling code here:
        logoclose.setForeground(Color.RED); //Ketika cursor diarahkan ke logo, maka warna berubah menjadi warna merah

    }//GEN-LAST:event_logocloseMouseEntered

    private void logocloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logocloseMouseExited
        // TODO add your handling code here:
        logoclose.setForeground(Color.WHITE); //ketika cursor tidak jadi memilih logo tsbt, maka logo berubah menjadi warna putih

    }//GEN-LAST:event_logocloseMouseExited

    private void logominimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logominimizeMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
        logominimize.setForeground(new Color (242, 241, 239));
        logominimize.setBackground(Color.WHITE);
    }//GEN-LAST:event_logominimizeMouseClicked

    private void logominimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logominimizeMouseEntered
        // TODO add your handling code here:
        logominimize.setForeground(Color.RED);
    }//GEN-LAST:event_logominimizeMouseEntered

    private void logominimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logominimizeMouseExited
        // TODO add your handling code here:
        logominimize.setForeground(Color.WHITE);
    }//GEN-LAST:event_logominimizeMouseExited

    private void label_judultubesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_judultubesMouseReleased
        // TODO add your handling code here:
        this.setOpacity(1.0f);
    }//GEN-LAST:event_label_judultubesMouseReleased

    private void home_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_panelMouseClicked
        // TODO add your handling code here:
        histori_konten.setVisible(false);
        edit_konten.setVisible(false);
        add_konten.setVisible(false);
        home_konten.setVisible(true);
    }//GEN-LAST:event_home_panelMouseClicked

    private void home_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_panelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_home_panelMouseEntered

    private void home_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_panelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_home_panelMouseExited

    private void add_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_panelMouseClicked
        // TODO add your handling code here:
        histori_konten.setVisible(false);
        edit_konten.setVisible(false);
        home_konten.setVisible(false);
        add_konten.setVisible(true);
    }//GEN-LAST:event_add_panelMouseClicked

    private void add_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_panelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add_panelMouseEntered

    private void add_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_panelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_add_panelMouseExited

    private void edit_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_panelMouseClicked
        // TODO add your handling code here:
        histori_konten.setVisible(false);
        home_konten.setVisible(false);
        add_konten.setVisible(false);
        edit_konten.setVisible(true);
        load_table();
    }//GEN-LAST:event_edit_panelMouseClicked

    private void edit_panelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_panelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_panelMouseEntered

    private void edit_panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_panelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_panelMouseExited

    private void home_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_panelMousePressed
        // TODO add your handling code here:
        setColor(home_panel);
        garis1.setOpaque(true);
        resetColor(new JPanel[]{add_panel,edit_panel,histori_panel}, new JPanel[]{garis2,garis3,garis4});
    }//GEN-LAST:event_home_panelMousePressed

    private void add_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_panelMousePressed
        // TODO add your handling code here:
        setColor(add_panel);
        garis2.setOpaque(true);
        resetColor(new JPanel[]{home_panel,edit_panel,histori_panel}, new JPanel[]{garis1,garis3,garis4});
    }//GEN-LAST:event_add_panelMousePressed

    private void edit_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_panelMousePressed
        // TODO add your handling code here:
        setColor(edit_panel);
        garis3.setOpaque(true);
        resetColor(new JPanel[]{home_panel,add_panel,histori_panel}, new JPanel[]{garis1,garis2,garis4});
    }//GEN-LAST:event_edit_panelMousePressed

    private void icon_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_backMouseClicked
        // TODO add your handling code here:
        AnimationClass bc1 = new AnimationClass();
        bc1.jLabelXRight(-810, 0, 25, 5, background_home);
        
        
        AnimationClass bc2 = new AnimationClass();
        bc2.jLabelXRight(0, 810, 25, 5, background2);
    }//GEN-LAST:event_icon_backMouseClicked

    private void icon_nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_nextMouseClicked
        // TODO add your handling code here:
        AnimationClass bc1 = new AnimationClass();
        AnimationClass bc2 = new AnimationClass();
        
        bc1.jLabelXLeft(0, -810, 25, 5, background_home);
        bc2.jLabelXLeft(810, 0, 25, 5, background2);
      //bc1.jLabelXLeft(ABORT, ERROR, WIDTH, NORMAL, jLabel1); start,stop,delay,increment
    }//GEN-LAST:event_icon_nextMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        AnimationClass bc1 = new AnimationClass();
        AnimationClass bc2 = new AnimationClass();
        
        bc1.jLabelXLeft(0, -810, 25, 5, background_home);
        bc2.jLabelXLeft(810, 0, 25, 5, background2);
    }//GEN-LAST:event_formWindowOpened

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_saveActionPerformed

    private void tabel_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_editMouseClicked
        //berguna ketika mengklik data ditable akan tampil di bagian sisi sebelah kiri
        int baris = tabel_edit.rowAtPoint(evt.getPoint());
        String nim = tabel_edit.getValueAt(baris, 1).toString();
        show_id.setText(nim);
        String nama = tabel_edit.getValueAt(baris, 2).toString();
        show_nama.setText(nama);
        String email = tabel_edit.getValueAt(baris, 3).toString();
        show_email.setText(email);
        String kategori = tabel_edit.getValueAt(baris, 4).toString();
        cb_kategori1.setSelectedItem(kategori);
        String item = tabel_edit.getValueAt(baris, 5).toString();
        cb_item1.setSelectedItem(item);
        String lokasi = tabel_edit.getValueAt(baris, 6).toString();
        cb_lokasi1.setSelectedItem(lokasi);
        String cat = tabel_edit.getValueAt(baris, 7).toString();
        Cb_keterangan.setSelectedItem(cat);
    }//GEN-LAST:event_tabel_editMouseClicked

    private void bt_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_saveMouseEntered
        // TODO add your handling code here:
        bt_save.setForeground(Color.WHITE);
        bt_save.setBackground(new Color (77, 175, 124));
    }//GEN-LAST:event_bt_saveMouseEntered

    private void bt_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_saveMouseExited
        // TODO add your handling code here:
        bt_save.setForeground(new Color (77, 175, 124));
        bt_save.setBackground(Color.WHITE);
    }//GEN-LAST:event_bt_saveMouseExited

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        edit();
    }//GEN-LAST:event_bt_saveActionPerformed

    private void histori_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_histori_panelMouseClicked
        home_konten.setVisible(false);
        add_konten.setVisible(false);
        edit_konten.setVisible(false);
        histori_konten.setVisible(true);
        load_table1();
    }//GEN-LAST:event_histori_panelMouseClicked

    private void histori_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_histori_panelMousePressed
        setColor(histori_panel);
        garis4.setOpaque(true);
        resetColor(new JPanel[]{home_panel,add_panel,edit_panel}, new JPanel[]{garis1,garis2,garis3});
    }//GEN-LAST:event_histori_panelMousePressed

    private void tabel_historiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_historiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel_historiMouseClicked

    private void MailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MailMouseClicked
        new mail().setVisible(true);
    }//GEN-LAST:event_MailMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new dashboard().setVisible(true);
                
                
                
            }
        });
    }
    private void setColor(JPanel pane){
        pane.setBackground(new Color(41,57,80));
    }
    
    private void resetColor(JPanel[] pane, JPanel [] indicators){
        for(int i=0; i<pane.length; i++){
            pane[i].setBackground(new Color(23,35,51));
        }
        for(int i=0; i<indicators.length; i++){
            indicators[i].setOpaque(false);
        }
        
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cb_keterangan;
    private javax.swing.JLabel Mail;
    private javax.swing.JPanel add_konten;
    private javax.swing.JPanel add_panel;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel background_home;
    private javax.swing.JButton bt_save;
    private java.awt.Button button1;
    private javax.swing.JPanel cardlayout;
    private javax.swing.JComboBox<String> cb_item;
    private javax.swing.JComboBox<String> cb_item1;
    private javax.swing.JComboBox<String> cb_kategori;
    private javax.swing.JComboBox<String> cb_kategori1;
    private javax.swing.JComboBox<String> cb_lokasi;
    private javax.swing.JComboBox<String> cb_lokasi1;
    private javax.swing.JLabel date1;
    private javax.swing.JPanel edit_konten;
    private javax.swing.JPanel edit_panel;
    private javax.swing.JPanel garis1;
    private javax.swing.JPanel garis2;
    private javax.swing.JPanel garis3;
    private javax.swing.JPanel garis4;
    private javax.swing.JLabel gbr_email;
    private javax.swing.JLabel gbr_email1;
    private javax.swing.JLabel gbr_item;
    private javax.swing.JLabel gbr_item1;
    private javax.swing.JLabel gbr_kategori;
    private javax.swing.JLabel gbr_kategori1;
    private javax.swing.JLabel gbr_kerusakan;
    private javax.swing.JLabel gbr_kerusakan1;
    private javax.swing.JLabel gbr_lokasi;
    private javax.swing.JLabel gbr_lokasi1;
    private javax.swing.JLabel gbr_lokasi2;
    private javax.swing.JLabel gbr_nama;
    private javax.swing.JLabel gbr_nama1;
    private javax.swing.JLabel gbr_nim;
    private javax.swing.JLabel gbr_nim1;
    private javax.swing.JPanel histori_konten;
    private javax.swing.JPanel histori_panel;
    private javax.swing.JPanel home_konten;
    private javax.swing.JPanel home_panel;
    private javax.swing.JButton icon_back;
    private javax.swing.JButton icon_next;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel kepala;
    private javax.swing.JPanel konten_home;
    private javax.swing.JPanel label_admin;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_judultubes;
    private javax.swing.JLabel label_kerusakan;
    private javax.swing.JLabel label_kerusakan1;
    private javax.swing.JLabel label_nama;
    private javax.swing.JLabel label_nim;
    private javax.swing.JLabel logoclose;
    private javax.swing.JLabel logominimize;
    private javax.swing.JPanel menu_label;
    private java.awt.Button save;
    private javax.swing.JTextField show_email;
    private javax.swing.JTextField show_id;
    private javax.swing.JTextField show_nama;
    private javax.swing.JTable tabel_edit;
    private javax.swing.JTable tabel_histori;
    private javax.swing.JScrollPane tabel_panel1;
    private javax.swing.JScrollPane tabel_panel2;
    private javax.swing.JTextField text_email;
    private javax.swing.JTextField text_nama;
    private javax.swing.JTextField text_nim;
    private javax.swing.JLabel wallpaper_konten_add;
    // End of variables declaration//GEN-END:variables
}
