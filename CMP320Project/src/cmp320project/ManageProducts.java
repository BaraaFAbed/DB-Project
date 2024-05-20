package cmp320project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author baraa
 */
public class ManageProducts extends javax.swing.JFrame {

    myDBCon dbCon;              // Database connection object
    ResultSet rs;               // To get query results
    ResultSet rs1;               // To get query results
    LoginUser user;             // current user
    
    /**
     * Creates new form ManageProducts
     */
    public ManageProducts(LoginUser user) {
        // Initializes GUI components created using the form editor in NetBeans or similar IDE
        initComponents();
        
        // getting user and warehouse ID
        this.user = user;
        
        // creating connection
        dbCon = new myDBCon();
        
        // Positions this JFrame to the center of the screen
        this.setLocationRelativeTo(null);
        
        // Fetch and display new data from the database to populate the form
        getNewData();  
    }
    
    // This method fetches and sets the data from the database to populate the form's fields
    private void getNewData() {

        try {
            // Query to fetch account details of employees
            rs = dbCon.executeStatement("SELECT P.productID, name, \"Size\", S.quantity FROM product P, stores S, supplies SP WHERE P.productId = S.productID AND P.productID = SP.productID AND SP.username = '" + user.username + "' ORDER BY p.productID ASC");
            
            // Moves the cursor of the result set to the first row and populates the form fields with data
            rs.beforeFirst();
            rs.first();
            populateFields();
        } catch (SQLException e) {
            // Display an error message in case of any SQL exceptions
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Display selected warehouse.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
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

        txtCapacity = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnAddNewEmp1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtCapacity.setEditable(false);
        txtCapacity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacityActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnNext.setText("Next >>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Products");

        btnPrevious.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnPrevious.setText("<< Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAddNewEmp1.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnAddNewEmp1.setText("Sales History");
        btnAddNewEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewEmp1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Total Sold:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Product ID:");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Product Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(297, 297, 297))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddNewEmp1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addGap(162, 162, 162))))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCapacity)
                    .addComponent(txtID)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnAddNewEmp1))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populateFields() {
        try {
            // Setting form fields with the current row's data from the result set.
            txtID.setText(rs.getString("productID"));
            txtName.setText(rs.getString("name"));
            rs1 = dbCon.executeStatement("SELECT SUM(Quantity) AS TotalQuantity FROM orderline WHERE productID = " + txtID.getText());
            rs1.next();
            txtCapacity.setText(Integer.toString(rs1.getInt("TotalQuantity")));
            
            // Update the navigation buttons' states.
            EnableDisableButtons();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // This method moves the result set's cursor to the next record and populates the form fields.
    private void MoveNext() {
        try {
            if (!rs.isLast()) {
                rs.next(); 
                populateFields();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // This method moves the result set's cursor to the previous record and populates the form fields.
    private void MovePrevious() {
        try {
            // TODO add your handling code here:
            if (!rs.isFirst()) {
                rs.previous();
                populateFields();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // This method updates the state of the navigation buttons based on the cursor's position in the result set.
    private void EnableDisableButtons() {
        try {
            // Disable the Previous button if we're at the first record.
            if (rs.isFirst()) {
                btnPrevious.setEnabled(false);
            } else {
                btnPrevious.setEnabled(true);
            }

            // Disable the Next button if we're at the last record.
            if (rs.isLast()) {
                btnNext.setEnabled(false);
            } else {
                btnNext.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void txtCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacityActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        MoveNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        MovePrevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnAddNewEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewEmp1ActionPerformed
        //TODO
        (new SalesHistoryForm(txtID.getText(), txtName.getText())).setVisible(true);
    }//GEN-LAST:event_btnAddNewEmp1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewEmp1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
