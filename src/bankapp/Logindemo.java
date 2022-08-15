package bankapp;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")
public class Logindemo extends javax.swing.JFrame {
    public Logindemo() {
        initComponents();
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("BANKING SYSTEM");
        jPanel1.add(jLabel1);
        jPanel1.setBackground(Color.lightGray);
        jLabel1.setBounds(130, 30, 220, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("Username:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 120, 70, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 200, 70, 20);
        jPanel1.add(txt_username);
        txt_username.setBounds(120, 120, 230, 30);
        jPanel1.add(txt_password);
        txt_password.setBounds(120, 200, 230, 30);

        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel1.add(login);
        login.setBounds(120, 290, 80, 23);

        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset);
        reset.setBounds(273, 290, 80, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {
   
                  String s1=txt_username.getText();
                  String s2=new String(txt_password.getPassword());
                    try
                    {
                       //Class.forName("com.mysql.jdbc.Driver");
                       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdetails","root","root");
                       Statement stmt=con.createStatement();
                       String query="select * from login where UserName='"+s1+"' and Password='"+s2+"'";
                        ResultSet rs=stmt.executeQuery(query);
                        if(rs.next())
                       {
                           JOptionPane.showMessageDialog(null,"username and password matched");
                           MainMenu u=new MainMenu();
                           u.setVisible(true);
                           this.dispose();
                          }
                     
                       else
                       {
                       JOptionPane.showMessageDialog(null,"username and password not match");
                       System.exit(0);
                       }
                    }
                catch(Exception ex)
                      {
                          JOptionPane.showMessageDialog(null,"login failed");
                      }
               
    }

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        txt_username.setText("");
        txt_password.setText("");
    }
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Logindemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logindemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logindemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logindemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
       

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logindemo().setVisible(true);
            }
        });
}

   
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JButton reset;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
   
}