/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import Connections.ConnectionToDB;
import Forms.Login;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Black Code
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
public class VoteForm extends javax.swing.JFrame {
Connection conn = null;
PreparedStatement pst = null;
ResultSet rs = null;
ArrayList<String> senList = new ArrayList<String>();
int updateSenList[] = new int[5];
int index;
String itemSelected;
String selected;
DefaultListModel dlm = new DefaultListModel();
int  presidentVote , vPresidentVote,secretaryVote,assistantSecretaryVote,treasurerVote,auditorsVote;
int courseVote;
    /**
     * Creates new form VoteForm
     */
    public VoteForm() {
        initComponents();
        conn = ConnectionToDB.ConnectToDB();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        populatePresident();
        populateVPresident();
        populateSecretary();
        populateAssistantSecretary();
        populateTreasurer();
        populateAuditors();
        populateSenators();
    }
    public void close(){
        WindowEvent we = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }
    public void populatePresident(){
        try{
            String sql = "SELECT lastname,firstname,middleinitial FROM candidates_info WHERE position='President'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                presidentCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middleinitial"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void populateVPresident(){
        try{
            String sql = "SELECT lastname,firstname,middleinitial FROM candidates_info WHERE position='V-President'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                vPresidentCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middleinitial"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void populateSecretary(){
        try{
            String sql = "SELECT lastname,firstname,middleinitial FROM candidates_info WHERE position='Secretary'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                secretaryCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middleinitial"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void populateAssistantSecretary(){
        try{
            String sql = "SELECT lastname,firstname,middleinitial FROM candidates_info WHERE position='Assistant Secretary'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                assistantSecretaryCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middleinitial"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void populateTreasurer(){
        try{
             String sql = "SELECT lastname,firstname,middleinitial FROM candidates_info WHERE position='Treasurer'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                treasurerCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middleinitial"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void populateAuditors(){
        try{
             String sql = "SELECT lastname,firstname,middleinitial FROM candidates_info WHERE position='Auditors'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                auditorsCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middleinitial"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void populateSenators(){
        try{
            String sql = "SELECT lastname,firstname,middleinitial FROM candidates_info WHERE position='Senators'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                senatorsCombo.addItem(rs.getString("lastname")+" "+rs.getString("firstname")+" "+rs.getString("middleinitial"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void selectVoteCountForPresident(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+presidentCombo.getSelectedItem()+"' AND position='President'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               presidentVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void selectVoteCountForVPresident(){
         try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+vPresidentCombo.getSelectedItem()+"' AND position='V-President'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
               vPresidentVote = Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void selectVoteCountForSecretary(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+secretaryCombo.getSelectedItem()+"' AND position='Secretary'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                secretaryVote =Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void selectVoteCountForAssistantSecretary(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+assistantSecretaryCombo.getSelectedItem()+"' AND position='Assistant Secretary'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                assistantSecretaryVote = Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void selectVoteCountForTreasurer(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+treasurerCombo.getSelectedItem()+"' AND position='Treasurer'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                treasurerVote = Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void selectVoteCountForAuditors(){
        try{
            String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+auditorsCombo.getSelectedItem()+"' AND position='Auditors'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                auditorsVote = Integer.parseInt(rs.getString("vote_count"))+ 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void selectVoteCountForSenators(){
          for(int x=0;x<senList.size();x++){
                 try{
                    String sql = "SELECT vote_count FROM candidates_info WHERE fullname='"+senList.get(x)+"' AND position='Senators'";
                    pst = conn.prepareStatement(sql);
                    rs  = pst.executeQuery();
                    if(rs.next()){   
                       updateSenList[x] = Integer.parseInt(rs.getString("vote_count")) + 1;
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } 
        
          }  
       
    }
    public void updateForPresident(){
        try{
            String sql = "UPDATE candidates_info SET vote_count='"+ presidentVote +"' WHERE fullname='"+presidentCombo.getSelectedItem()+"' AND position='President'";
            pst = conn.prepareStatement(sql);
            pst.execute();
  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateForVPresident(){
    try{
            String sql = "UPDATE candidates_info SET vote_count='"+ vPresidentVote +"' WHERE fullname='"+vPresidentCombo.getSelectedItem()+"' AND position='V-President'";
            pst = conn.prepareStatement(sql);
            pst.execute();
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateForSecretary(){
        try{
            String sql = "UPDATE candidates_info SET vote_count='"+ secretaryVote +"' WHERE fullname='"+secretaryCombo.getSelectedItem()+"' AND position='Secretary'";
            pst = conn.prepareStatement(sql);
            pst.execute();
   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateForAssistantSecretary(){
    try{
            String sql = "UPDATE candidates_info SET vote_count='"+ assistantSecretaryVote +"' WHERE fullname='"+assistantSecretaryCombo.getSelectedItem()+"' AND position='Assistant Secretary'";
            pst = conn.prepareStatement(sql);
            pst.execute();
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    public void updateForTreasurer(){
        try{
            String sql = "UPDATE candidates_info SET vote_count='"+ treasurerVote +"' WHERE fullname='"+treasurerCombo.getSelectedItem()+"' AND position='Treasurer'";
            pst = conn.prepareStatement(sql);
            pst.execute();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void updateForAuditors(){
    try{
            String sql = "UPDATE candidates_info SET vote_count='"+ auditorsVote +"' WHERE fullname='"+auditorsCombo.getSelectedItem()+"' AND position='Auditors'";
            pst = conn.prepareStatement(sql);
            pst.execute();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }   
    }
    public void updateForSenators(){
        for(int x=0;x<updateSenList.length;x++){
            try{
                String sql = "UPDATE candidates_info SET vote_count='"+updateSenList[x]+"' WHERE fullname='"+senList.get(x)+"' AND position = 'Senators'";
                pst = conn.prepareStatement(sql);
                pst.execute();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }  
        }
        
     
    }
    public void selectCourse(){
        try{
            String sql = "SELECT vote_count FROM courses WHERE course='"+courseLbl.getText()+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                courseVote = Integer.parseInt(rs.getString("vote_count")) + 1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void updateCourseVote(){
        try{
            String sql = "UPDATE courses SET vote_count='"+ courseVote +"' WHERE course='"+courseLbl.getText()+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
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
        voteCombo = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        senatorsListTxt = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        assistantSecretaryCombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        vPresidentCombo = new javax.swing.JComboBox();
        auditorsCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        presidentCombo = new javax.swing.JComboBox();
        senatorsCombo = new javax.swing.JComboBox();
        treasurerCombo = new javax.swing.JComboBox();
        secretaryCombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addSenatorBtn = new javax.swing.JButton();
        removeSenatorBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        courseLbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ageLbl = new javax.swing.JLabel();
        statusLbl = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        yearLbl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Please select your candidates", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        voteCombo.setText("Vote");
        voteCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteComboActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Senators");

        senatorsListTxt.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        senatorsListTxt.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                senatorsListTxtValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(senatorsListTxt);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("V - President");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Treasurer");

        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        assistantSecretaryCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        assistantSecretaryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Auditors");

        vPresidentCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        vPresidentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        auditorsCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        auditorsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Assistant Secretary");

        presidentCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        presidentCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        senatorsCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        senatorsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        treasurerCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        treasurerCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        secretaryCombo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        secretaryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("President");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Secretary");

        addSenatorBtn.setText("Add Senator");
        addSenatorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSenatorBtnActionPerformed(evt);
            }
        });

        removeSenatorBtn.setText("Remove Senator");
        removeSenatorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSenatorBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Pick 5 Senators in the list:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(auditorsCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(treasurerCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(assistantSecretaryCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(secretaryCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vPresidentCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(presidentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addSenatorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeSenatorBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(voteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(senatorsCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel9))
                .addContainerGap(267, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(presidentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(senatorsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vPresidentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSenatorBtn)
                    .addComponent(removeSenatorBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(secretaryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(assistantSecretaryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(treasurerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(auditorsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voteCombo)
                    .addComponent(exitBtn))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("Please Vote Wisely!");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Students Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("Year:");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Age:");

        nameLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameLbl.setForeground(new java.awt.Color(102, 0, 0));
        nameLbl.setText("Name");

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel15.setText("Status:");

        courseLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        courseLbl.setForeground(new java.awt.Color(102, 0, 0));
        courseLbl.setText("Course");

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Name:");

        ageLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        ageLbl.setForeground(new java.awt.Color(102, 0, 0));
        ageLbl.setText("Age");

        statusLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        statusLbl.setForeground(new java.awt.Color(102, 0, 0));
        statusLbl.setText("Status");

        genderLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        genderLbl.setForeground(new java.awt.Color(102, 0, 0));
        genderLbl.setText("Gender");

        yearLbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        yearLbl.setForeground(new java.awt.Color(102, 0, 0));
        yearLbl.setText("Year");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel12.setText("Gender:");

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Course:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genderLbl)
                    .addComponent(ageLbl)
                    .addComponent(nameLbl))
                .addGap(249, 249, 249)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusLbl)
                    .addComponent(yearLbl)
                    .addComponent(courseLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(nameLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(ageLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(genderLbl)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(courseLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(yearLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(statusLbl))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        Login l = new Login();
        close();
        l.setVisible(true);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void removeSenatorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSenatorBtnActionPerformed
        String s = selected;    
        try{
                if(index==-1){
                    JOptionPane.showMessageDialog(null, "Please select a senetor to remove");
                }else{
   
                    senList.remove(index);
                   dlm.removeElementAt(index);
                   senatorsCombo.addItem(s);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
             //  JOptionPane.showMessageDialog(null, selected);
  
            //  
              
    
      
          
    }//GEN-LAST:event_removeSenatorBtnActionPerformed

    private void addSenatorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSenatorBtnActionPerformed
            int itemAdded =   senatorsListTxt.getModel().getSize();
        
         if(senatorsCombo.getSelectedItem().equals("-")){
                JOptionPane.showMessageDialog(null, "Please select a senator to add");
         }else{
                    if(itemAdded<5){
                           dlm.clear();
                           
                            int addedIndex = senatorsCombo.getSelectedIndex();

                            senList.add(senatorsCombo.getSelectedItem().toString());
                                
                   

                            for(int x=0;x<senList.size();x++){
                                dlm.addElement(senList.get(x));
                            }
                            senatorsListTxt.setModel(dlm);
                           senatorsCombo.removeItemAt(addedIndex);
                          
                            senatorsCombo.setSelectedIndex(0);
                    }else{
                             JOptionPane.showMessageDialog(null, "Only 5 senators are allowed!");
                    }
                  
                       
                        
         } 
        
      
       
        
  
        
    }//GEN-LAST:event_addSenatorBtnActionPerformed

    private void voteComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voteComboActionPerformed
      
        if(presidentCombo.getSelectedIndex()==0 || vPresidentCombo.getSelectedIndex()==0 || secretaryCombo.getSelectedIndex()==0 || assistantSecretaryCombo.getSelectedIndex()==0 || treasurerCombo.getSelectedIndex()==0 || auditorsCombo.getSelectedIndex()==0 || senatorsListTxt.getModel().getSize() == 0){
               JOptionPane.showMessageDialog(null, "Please fill up all the required fields");
           }else{
                int des = JOptionPane.showConfirmDialog(null, "Finish Voting?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(des==0){
                    selectVoteCountForPresident();
               selectVoteCountForVPresident();
               selectVoteCountForSecretary();
               selectVoteCountForAssistantSecretary();
               selectVoteCountForTreasurer();
               selectVoteCountForAuditors();
               selectVoteCountForSenators();
               selectCourse();
               
                updateForPresident();
                updateForVPresident();
                updateForSecretary();
                updateForAssistantSecretary();
                updateForTreasurer();
                updateForAuditors();
                updateForSenators();
                updateCourseVote();
                JOptionPane.showMessageDialog(null, "Voted Successfully!");
                }
               
           }
    }//GEN-LAST:event_voteComboActionPerformed

    private void senatorsListTxtValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_senatorsListTxtValueChanged
 
          index = senatorsListTxt.getSelectedIndex();
         selected=String.valueOf(senatorsListTxt.getSelectedValue());
  
    
        
       
    }//GEN-LAST:event_senatorsListTxtValueChanged

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
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoteForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSenatorBtn;
    public javax.swing.JLabel ageLbl;
    private javax.swing.JComboBox assistantSecretaryCombo;
    private javax.swing.JComboBox auditorsCombo;
    public javax.swing.JLabel courseLbl;
    private javax.swing.JButton exitBtn;
    public javax.swing.JLabel genderLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel nameLbl;
    private javax.swing.JComboBox presidentCombo;
    private javax.swing.JButton removeSenatorBtn;
    private javax.swing.JComboBox secretaryCombo;
    private javax.swing.JComboBox senatorsCombo;
    private javax.swing.JList senatorsListTxt;
    public javax.swing.JLabel statusLbl;
    private javax.swing.JComboBox treasurerCombo;
    private javax.swing.JComboBox vPresidentCombo;
    private javax.swing.JButton voteCombo;
    public javax.swing.JLabel yearLbl;
    // End of variables declaration//GEN-END:variables
}
