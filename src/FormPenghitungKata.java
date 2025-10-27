import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FormPenghitungKata extends javax.swing.JFrame {

    public FormPenghitungKata() {
        initComponents();
        
         // Tambahkan DocumentListener agar real-time
        txtAreaInput.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            hitungTeks();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            hitungTeks();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            hitungTeks();
        }
    });
    }
    
    // === FUNGSI UTAMA ===
    private void hitungTeks() {
        String teks = txtAreaInput.getText().trim();

        // Hitung kata
        String[] kata = teks.split("\\s+");
        int jumlahKata = (teks.isEmpty()) ? 0 : kata.length;

        // Hitung karakter
        int jumlahKarakter = teks.length();

        // Hitung kalimat (regex titik, tanda seru, tanda tanya)
        String[] kalimat = teks.split("[.!?]");
        int jumlahKalimat = (teks.isEmpty()) ? 0 : kalimat.length;

        // Hitung paragraf (pisah newline)
        String[] paragraf = teks.split("\\n+");
        int jumlahParagraf = (teks.isEmpty()) ? 0 : paragraf.length;

        // Tampilkan ke label
        lblJumlahKata.setText("Jumlah Kata: " + jumlahKata);
        lblJumlahKarakter.setText("Jumlah Karakter: " + jumlahKarakter);
        lblJumlahKalimat.setText("Jumlah Kalimat: " + jumlahKalimat);
        lblJumlahParagraf.setText("Jumlah Paragraf: " + jumlahParagraf);
    }

    private void cariKata() {
        String teks = txtAreaInput.getText().toLowerCase();
        String cari = txtCari.getText().toLowerCase();

        int count = 0;
        int index = 0;
        while ((index = teks.indexOf(cari, index)) != -1) {
            count++;
            index += cari.length();
        }

        lblHasilCari.setText("Kata '" + cari + "' ditemukan: " + count + " kali");
    }

    private void simpanKeFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter writer = new PrintWriter(chooser.getSelectedFile())) {
                writer.println("Teks Asli:\n" + txtAreaInput.getText());
                writer.println(lblJumlahKata.getText());
                writer.println(lblJumlahKarakter.getText());
                writer.println(lblJumlahKalimat.getText());
                writer.println(lblJumlahParagraf.getText());
                writer.println(lblHasilCari.getText());
                JOptionPane.showMessageDialog(this, "Berhasil disimpan!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + e.getMessage());
            }
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnHitung = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblJumlahKata = new javax.swing.JLabel();
        lblJumlahKarakter = new javax.swing.JLabel();
        lblJumlahKalimat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaInput = new javax.swing.JTextArea();
        lblJumlahParagraf = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        lblHasilCari = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 310));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(249, 245, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(544, 45));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("Aplikasi Penghitung Kata");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(52, 79, 31));

        btnHitung.setBackground(new java.awt.Color(244, 153, 26));
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        btnCari.setBackground(new java.awt.Color(244, 153, 26));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(244, 153, 26));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(244, 153, 26));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnHitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(242, 234, 211));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJumlahKata.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblJumlahKata.setText("Jumlah Kata");
        jPanel3.add(lblJumlahKata, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lblJumlahKarakter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblJumlahKarakter.setText("Jumlah Karakter");
        jPanel3.add(lblJumlahKarakter, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        lblJumlahKalimat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblJumlahKalimat.setText("Jumlah Kalimat");
        jPanel3.add(lblJumlahKalimat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        txtAreaInput.setColumns(20);
        txtAreaInput.setRows(5);
        jScrollPane1.setViewportView(txtAreaInput);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 443, 118));

        lblJumlahParagraf.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblJumlahParagraf.setText("Jumlah Paragraf");
        jPanel3.add(lblJumlahParagraf, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));
        jPanel3.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 176, 240, -1));

        lblHasilCari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblHasilCari.setText("Hasil Cari");
        jPanel3.add(lblHasilCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        hitungTeks();
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cariKata();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        simpanKeFile();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
    txtAreaInput.setText("");
    txtCari.setText("");
    lblJumlahKata.setText("Jumlah Kata: 0");
    lblJumlahKarakter.setText("Jumlah Karakter: 0");
    lblJumlahKalimat.setText("Jumlah Kalimat: 0");
    lblJumlahParagraf.setText("Jumlah Paragraf: 0");
    lblHasilCari.setText("Hasil Pencarian: -");    }//GEN-LAST:event_btnResetActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenghitungKata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenghitungKata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHasilCari;
    private javax.swing.JLabel lblJumlahKalimat;
    private javax.swing.JLabel lblJumlahKarakter;
    private javax.swing.JLabel lblJumlahKata;
    private javax.swing.JLabel lblJumlahParagraf;
    private javax.swing.JTextArea txtAreaInput;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
