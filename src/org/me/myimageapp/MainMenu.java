/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.myimageapp;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.me.myimageapp.ImageDisplay.nicknamethrow;


/**
 *
 * @author ACER
 */
public final class MainMenu extends javax.swing.JFrame 
{  
    static String timer;
    static String val2; 
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/chatapplication";
    static final String USER = "root";
    static final String PASS = "";
    static String sql;
    static ResultSet rs;
    static ResultSet rs1;
    static String t1,t2,t3,t4,t5;
    static String allstring;
    static String user,passy;
    public MainMenu(String us,String pas,String nickname, String gc) 
    {
        initComponents();
        user = us; passy=pas;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = 450;
		int height = 450;
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;
		setLocation(x,y); 
                allchattext();  
                timeprocessor();
                 
                if(nickname.equals(""))
                {
                }
                else
                {
                     val1 = nickname;
                }
                if(gc.equals(""))
                {
                }
                else
                {    
                    val2 = gc;  
                }
                
                javax.swing.Timer t = new javax.swing.Timer(1000,new ActionListener(){@Override
         public void actionPerformed(ActionEvent e){
   				String am_pm;
   				Calendar now = Calendar.getInstance();
                int h = now.get(Calendar.HOUR_OF_DAY);
                int m = now.get(Calendar.MINUTE);
                int s = now.get(Calendar.SECOND);
                timer = " " + h + ":" + m + ":" + s + " ";    
                setTitle("IT SOURCECODE - "+val1);
                
                    findchat();  
            }
        });
        t.start();
                
    } 

    private MainMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    void timeprocessor()
    {
        
        
    }
     
    void findchat()
    {
        
        
        Connection conn = null;
         Statement stmt = null;
         //nicknamethrow=rs.getString("MyID");
        try{    
            Class.forName(JDBC_DRIVER); 
            conn = DriverManager.getConnection(DB_URL,USER,PASS); 
            stmt = conn.createStatement();   
            sql="SELECT * FROM mychat where ChatGroup = '"+val2+"'";   
            rs = stmt.executeQuery(sql);
             
            allchat.setText("");
            while (rs.next()) {
                  
                   t1=rs.getString("Sender");
                 t2=rs.getString("Chat");
                 t3=rs.getString("Time");
                 t4=rs.getString("Type");
                 t5=rs.getString("ChatGroup"); 
                 allstring ="\n "+t1+" ["+t3+"] \n >>"+t2+"\n";
                 allstring = allchat.getText()+allstring  ;
                 allchat.setText("");
                allchat.setText(allstring);   
                 
              }   
           
	     rs.close();  
             conn.close();
        }catch(Exception er)
        { 
        } 
    }
     void savesome() throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        Connection conn = null;
         Statement stmt = null;
    try {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        String Sender,Chat,Time,Type,ChatGroup;
        Sender = val1;
        Chat = jTextArea2.getText(); 
        Time = timer;
        ChatGroup = val2;
        stmt = conn.createStatement();   
        sql="INSERT INTO `mychat` (`Sender`, `Chat`, `Time`, `Type`, `ChatGroup`, `Remarks`) VALUES ('"+Sender+"','"+Chat+"','"+Time+"','','"+val2+"','')";
        stmt.executeUpdate(sql);
        JOptionPane.showConfirmDialog(null, "Message Sent!",
                "Result", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        conn.close();
        stmt.close(); 
        jTextArea2.setText(""); 
    }

    catch (SQLException e1)
    {
        System.out.println("Exception:" + e1);
    }
    }
    void allchattext() 
    { 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allchat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        button1 = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                wnclose(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                wnopen(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        allchat.setEditable(false);
        allchat.setBackground(new java.awt.Color(102, 102, 102));
        allchat.setColumns(20);
        allchat.setForeground(new java.awt.Color(255, 255, 255));
        allchat.setRows(5);
        jScrollPane1.setViewportView(allchat);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setNextFocusableComponent(button1);
        jScrollPane2.setViewportView(jTextArea2);

        button1.setBackground(new java.awt.Color(0, 255, 0));
        button1.setForeground(new java.awt.Color(0, 0, 0));
        button1.setLabel("Send");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Chat Application Using Java");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Find");

        jMenuItem12.setText("Create Connection");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem13.setText("Join Connection");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem13);

        jMenuBar1.add(jMenu1);

        jMenu8.setForeground(new java.awt.Color(255, 255, 255));
        jMenu8.setText("System");

        jMenuItem3.setText("Logout");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jMenuItem4.setText("System Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
         new CreateCon().setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        new conPrivate().setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
     
        try {
            // TODO add your handling code here:
            savesome(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_button1ActionPerformed

    private void wnopen(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_wnopen
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"\n Welcome ! \n" +
" Before to fully use this software, you must :\n" +
" \n" +
" 1. Internet connection is available.\n" +
" 2. Your anti-virus allow this program to run. \n" + 
"\n" +
" Thank you !");
    }//GEN-LAST:event_wnopen

    private void wnclose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_wnclose
        // TODO add your handling code here:
         Connection conn = null;
         Statement stmt = null;
         try{
             String disconnectUpdate = "delete from myaccounts where Username = '"+user+"' and Password = '"+passy+"'";
             String updateAccountAvailable = "INSERT INTO myaccounts(Username, Password, MyID, Remarks)VALUES('"+user+"','"+passy+"','"+nicknamethrow+"','')";
             Class.forName(JDBC_DRIVER); 
             conn = DriverManager.getConnection(DB_URL,USER,PASS); 
             stmt = conn.createStatement();  
             stmt.execute(disconnectUpdate);
             stmt.execute(updateAccountAvailable);
             stmt.close();
             conn.close();
         }catch(Exception error){
             
         }
        
    }//GEN-LAST:event_wnclose

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        int dialog = JOptionPane.showConfirmDialog(null,"Are you sure ?","Warning",JOptionPane.YES_NO_OPTION);	
						if(dialog == JOptionPane.YES_OPTION)
						{
         new ImageDisplay().setVisible(true);
                this.dispose();}
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
            // TODO add your handling code here:
            int dialog = JOptionPane.showConfirmDialog(null,"Are you sure ?","Warning",JOptionPane.YES_NO_OPTION);	
						if(dialog == JOptionPane.YES_OPTION)
						{
            System.exit(0);}
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Connection conn = null;
         Statement stmt = null;
         try{
             String disconnectUpdate = "delete from myaccounts where Username = '"+user+"' and Password = '"+passy+"'";
             String updateAccountAvailable = "INSERT INTO myaccounts(Username, Password, MyID, Remarks)VALUES('"+user+"','"+passy+"','"+nicknamethrow+"','')";
             Class.forName(JDBC_DRIVER); 
             conn = DriverManager.getConnection(DB_URL,USER,PASS); 
             stmt = conn.createStatement();  
             stmt.execute(disconnectUpdate);
             stmt.execute(updateAccountAvailable);
             stmt.close();
             conn.close();
         }catch(Exception error){
             
         }
    }//GEN-LAST:event_formWindowClosing
   
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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
             public void run() {
                new MainMenu().setVisible(true);
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea allchat;
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
    Image img =(new ImageIcon(getClass().getResource("logo.jpg"))).getImage(); 
    String val1,val3;
}
