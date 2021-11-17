/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTPT;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class frm_client extends javax.swing.JFrame {
    static DatagramSocket socket;
    String name;
    int giay=0;
    ThuatToanRSA rSA;
    ThuatToanDES dES;
    ThuatToanAES aES;
    String key;
    int typeEncode=0;
    static InetAddress address;
    static int port;
    /**
     * Creates new form frmMain
     * @throws java.net.SocketException
     * @throws java.net.UnknownHostException
     */
    public frm_client() throws SocketException, UnknownHostException {
        initComponents();
        //socket = new DatagramSocket();
        
        dES= new ThuatToanDES();
        rSA= new ThuatToanRSA();
        
        aES= new ThuatToanAES();
        key="ABC";
        
        btn_ToServer.setEnabled(false);
        ta_Chat.setEditable(false);
        cbb_MaHoa.setEnabled(false);
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        try {
            if(btn_ToServer.isEnabled())
                send(socket, address, port, "exit");
        } catch (IOException ex) {
            Logger.getLogger(frm_client.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.exit(0);
    }
});
                
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_DiaChi = new javax.swing.JTextField();
        tf_Cong = new javax.swing.JTextField();
        btn_KetNoi = new javax.swing.JButton();
        lb_ThongBao = new javax.swing.JLabel();
        tf_Name = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_ToServer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Chat = new javax.swing.JTextArea();
        cbb_MaHoa = new javax.swing.JComboBox<>();
        tf_Type = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(1000, 400));
        setName("frame"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Function"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Connect server", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel7.setText("Port:");

        jLabel6.setText("Address:");

        tf_DiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_DiaChiKeyTyped(evt);
            }
        });

        tf_Cong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tf_CongMouseExited(evt);
            }
        });
        tf_Cong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_CongActionPerformed(evt);
            }
        });

        btn_KetNoi.setText("Connect");
        btn_KetNoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KetNoiActionPerformed(evt);
            }
        });

        lb_ThongBao.setText("Status: Disconnect");

        tf_Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tf_NameMouseExited(evt);
            }
        });

        jLabel8.setText("Name:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_ThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_KetNoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_Name)
                    .addComponent(tf_Cong)
                    .addComponent(tf_DiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_Cong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_KetNoi)
                .addGap(11, 11, 11)
                .addComponent(lb_ThongBao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Send and receive message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btn_ToServer.setText("To server");
        btn_ToServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ToServerActionPerformed(evt);
            }
        });

        ta_Chat.setColumns(20);
        ta_Chat.setRows(5);
        jScrollPane1.setViewportView(ta_Chat);

        cbb_MaHoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AES", "DES", "RSA" }));
        cbb_MaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_MaHoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(tf_Type)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ToServer))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cbb_MaHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(cbb_MaHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ToServer))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(127, 127, 127))
        );

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel1.setText("CLIENT-SERVER WITH UDP");

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Nhóm:");

        jLabel3.setText("Đỗ Tấn Thành");

        jLabel4.setText("Nguyễn Lê Tấn Tài");

        jLabel5.setText("Phan Văn Lũy");

        jLabel11.setText("Nguyễn Hải Đăng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(59, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("CLIENT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_CongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_CongActionPerformed
        // TODO add your handling code here:
        port=Integer.parseInt(tf_Cong.getText());
    }//GEN-LAST:event_tf_CongActionPerformed

    public static void  send(DatagramSocket socket, InetAddress address, int port, String sendString) throws IOException
    {
        byte sendData[];
        sendData=sendString.getBytes();
        DatagramPacket sendPacket= new DatagramPacket(sendData, sendData.length, address, port);
        socket.send(sendPacket);
        
    }
    public static DatagramPacket receive(DatagramSocket socket) throws IOException
    {
        byte receiveData[]= new byte[8888];
        DatagramPacket receivePacket= new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        return receivePacket;
    }
    private void btn_KetNoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KetNoiActionPerformed
        
        if("".equals(tf_Name.getText()))
        {
            //Nhớ đặt tên cho server
            lb_ThongBao.setText("Name is not null");
            return;
        }
        if("".equals(tf_Cong.getText()))
        {
            //Nhớ đặt tên cho server
            lb_ThongBao.setText("Port is not null");
            return;
        }
        if("".equals(tf_DiaChi.getText()))
        {
            //Nhớ đặt tên cho server
            lb_ThongBao.setText("Address is not null");
            return;
        }
        
        try {
            Timer timer = new Timer("MyTimer");//create a new Timer
            socket = new DatagramSocket();
            port=Integer.parseInt(tf_Cong.getText());
            // TODO add your handling code here:
            address= InetAddress.getByName(tf_DiaChi.getText());
            name=tf_Name.getText();
            String sendString="from client to server";
            System.out.println("Cong: "+port+" dia chi: "+address);
            //gửi chuỗi xác lập kết nối
            send(socket, address, port, sendString);
            
            //quá 4 giây không kết nối đc là dừng kết nối
            
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    giay++;//Đếm giây
                    if(giay%5==0 && btn_KetNoi.isEnabled())
                    {   
                        socket.close(); 
                        lb_ThongBao.setText("Status: Failed");
                    }
                }
            };
            timer.schedule(timerTask, 0, 1000);//Lên lịch
            
            DatagramPacket receivePacket= receive(socket);
            
            lb_ThongBao.setText("Status: "+new String(receivePacket.getData()).trim());
            
            if(new String(receivePacket.getData()).trim().equalsIgnoreCase("Connect was successful!"))
            {
                cbb_MaHoa.setEnabled(true);
                tf_Cong.setEnabled(false);
                tf_DiaChi.setEnabled(false);
                tf_Name.setEnabled(false);
                btn_KetNoi.setEnabled(false);
                btn_ToServer.setEnabled(true);
            }
        } catch (UnknownHostException|SocketException ex) {
            Logger.getLogger(frm_server.class.getName()).log(Level.SEVERE, null, ex);
            lb_ThongBao.setText("Status: Failed");
            btn_ToServer.setEnabled(false); 
            cbb_MaHoa.setEnabled(false);
            
        }catch (IOException ex) {
            Logger.getLogger(frm_server.class.getName()).log(Level.SEVERE, null, ex);
            lb_ThongBao.setText("Status: Failed");
            btn_ToServer.setEnabled(false);
            cbb_MaHoa.setEnabled(false);
        }
    }//GEN-LAST:event_btn_KetNoiActionPerformed

    void waitServerReponse(DatagramSocket socket) throws IOException
    {
        try {
             while(true)
            {
                DatagramPacket receivePacket= receive(socket);
                String receiveString = new String(receivePacket.getData()).trim();
                System.out.println("Receive from server (chưa giải mã): "+receiveString+";");
                typeEncode=cbb_MaHoa.getSelectedIndex();
                switch (typeEncode) {
                    case 0://AES
                        receiveString= aES.giaiMaAES(receiveString, key);
                        break;
                    case 1://DES
                        receiveString= dES.giaiMaDES(receiveString);
                        break;
                    case 2: //RSA
                        try {
                            receiveString =rSA.giaiMaRSA(receiveString);
                        } catch (Exception ex) {
                            Logger.getLogger(frm_client.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                        break;
                    default:
                        break;
                }
                System.out.println("Receive from server: "+receiveString+";");
                if(!"".equals(receiveString))
                    ta_Chat.setText(ta_Chat.getText()+receiveString+"\n");
                
                if("null".equals(receiveString))
                    ta_Chat.setText(ta_Chat.getText()+"You changed the type of code in combobox when server send message to you "+"\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(frm_server.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    private void btn_ToServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ToServerActionPerformed
       
        
        try {
           // socket=new DatagramSocket();
            System.out.flush(); 
            String sendString;
            sendString=tf_Type.getText();
            if("".equals(sendString.trim())) return;// Chuỗi trống thì out
            sendString=name+": "+sendString;
            switch (cbb_MaHoa.getSelectedIndex()) {
                case 0://AES
                    sendString=aES.maHoaAES(sendString, key);
                    break;
                case 1://DES
                    sendString= dES.maHoaDES(sendString);
                    break;
                case 2://RSA
                    sendString =rSA.maHoaRSA(sendString);
                    break;
                default:
                    break;
            }
            //Gửi lên server
            sendString=cbb_MaHoa.getSelectedItem()+"-"+sendString;// AES-client1: Hello
            send(socket, address, port, sendString);
            
            //Xử lý ô hiển thị message
            ta_Chat.setText(ta_Chat.getText()+tf_Type.getText()+"\n");
            tf_Type.setText("");
            
              //DatagramSocket socket = new DatagramSocket();
            Thread t = new Thread() {
                    @Override
                    public void run() {
                        try {
                            waitServerReponse(socket);
                        } catch (IOException ex) {
                            Logger.getLogger(frm_client.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
            t.start();

            //socket.close();--> Luồng nhận packet bị đóng, ko thể nhận dữ liệu từ server 
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(frm_client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(frm_client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frm_client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btn_ToServerActionPerformed

    private void tf_NameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_NameMouseExited
        // TODO add your handling code here:
            name=tf_Name.getText();
    }//GEN-LAST:event_tf_NameMouseExited

    private void cbb_MaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_MaHoaActionPerformed
        // TODO add your handling code here:
        int temp=typeEncode;
        if(!"".equals(ta_Chat.getText()))
        {
            int output =JOptionPane.showConfirmDialog(this, "This change maybe cause null message\nif server are sending message to you!!","Warning!!!!",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //chọn no thì back lại 
            if(output==JOptionPane.YES_OPTION)
            {
                typeEncode=cbb_MaHoa.getSelectedIndex();
            }
            else
            {
                cbb_MaHoa.setSelectedIndex(temp);
            }
        }
    }//GEN-LAST:event_cbb_MaHoaActionPerformed

    private void tf_CongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_CongMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tf_CongMouseExited

    private void tf_DiaChiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_DiaChiKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tf_DiaChiKeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new frm_client().setVisible(true);
            } catch (SocketException | UnknownHostException ex) {
                Logger.getLogger(frm_client.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_KetNoi;
    private javax.swing.JButton btn_ToServer;
    private javax.swing.JComboBox<String> cbb_MaHoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_ThongBao;
    private javax.swing.JTextArea ta_Chat;
    private javax.swing.JTextField tf_Cong;
    private javax.swing.JTextField tf_DiaChi;
    private javax.swing.JTextField tf_Name;
    private javax.swing.JTextField tf_Type;
    // End of variables declaration//GEN-END:variables
}