package cmp320project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author baraa
 */
public class TransferForm extends javax.swing.JFrame {

    myDBCon dbCon;              // Database connection object
    ResultSet rs;               // To get query results
    ResultSet rs1;              // To get query results
    ResultSet rs2;              // To get query results
    ResultSet rs3;              // To get query results
    ResultSet rs4;              // To get query results
    ResultSet rs5;              // To get query results
    int wareID;                 // current warehouse
    LoginUser user;
    
    /**
     * Creates new form TransferForm
     */
    public TransferForm(int warehouseID, LoginUser user) {
        // Initializes GUI components created using the form editor in NetBeans or similar IDE
        initComponents();
        
        // getting user and warehouse ID
        this.user = user;
        this.wareID = warehouseID;
        
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
            rs = dbCon.executeStatement("SELECT P.ProductID, S.WarehouseID FROM Product P, Stores S WHERE S.ProductID = P.ProductID ORDER BY ProductID ASC ");
            
            // Moves the cursor of the result set to the first row and populates the form fields with data
            rs.beforeFirst();
            rs.first();
            populateFields();
        } catch (SQLException e) {
            // Display an error message in case of any SQL exceptions
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Display selected username.");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbProduct = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        cmbWarehouse = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Transfer Product");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Product:");

        cmbProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Consumed Capacity:");

        txtCapacity.setEditable(false);
        txtCapacity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cmbWarehouse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Destination Warehouse:");

        btnUpdate.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnUpdate.setText("Transfer");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Current Warehouse ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(184, 184, 184))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate)
                            .addGap(51, 51, 51)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbProduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateFields() {
        try {
            rs5 = dbCon.executeStatement("SELECT Quantity, \"Size\" FROM Product P, Stores S WHERE S.ProductID = P.ProductID AND P.ProductID = " + cmbProduct.getSelectedItem().toString());
            rs5.next();
            txtCapacity.setText(Integer.toString(rs5.getInt("Quantity") * rs5.getInt("Size")));                   
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void populateFields() {
        try {
            rs1 = dbCon.executeStatement("SELECT P.productID FROM Product P, Stores S WHERE S.ProductID = P.ProductID AND warehouseID = " + Integer.toString(wareID));
            // Populate the combo box with data from the ResultSet
            while (rs1.next()) {
                cmbProduct.addItem(rs1.getString("productID"));
            }
            
            
            updateFields();
            txtID.setText(Integer.toString(wareID));
            
            rs2 = dbCon.executeStatement("SELECT UNIQUE warehouseID FROM warehouse WHERE warehouseID <> " + txtID.getText() + " ORDER BY WarehouseID ASC");
            // Populate the combo box with data from the ResultSet
            while (rs2.next()) {
                cmbWarehouse.addItem(rs2.getString("warehouseID"));
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean isWarehouseFull()
    {
        try {
            rs3 = dbCon.executeStatement("SELECT SUM(\"Size\" * Quantity) AS UsedCapacity FROM stores S JOIN product P ON S.ProductID = P.ProductID WHERE WarehouseID = " + cmbWarehouse.getSelectedItem().toString());
            rs3.next();
            rs4 = dbCon.executeStatement("SELECT capacity FROM warehouse WHERE WarehouseID = " + cmbWarehouse.getSelectedItem().toString());
            rs4.next();
            if (rs3.getString("UsedCapacity") == null) return false;
            else if (Integer.parseInt(rs3.getString("UsedCapacity")) + Integer.parseInt(txtCapacity.getText()) > rs4.getInt("Capacity")) return true;
            else return false;
        } catch (SQLException ex) {
            Logger.getLogger(TransferForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Prompt the user for confirmation before proceeding with the update.
        int returnValue = JOptionPane.showConfirmDialog(this, "Are you sure you want to transfer the product?", "Warning", JOptionPane.YES_NO_OPTION);
        if (returnValue != JOptionPane.YES_OPTION) {
            return;  // Exit the method if user selects "No"
        }

        try {
            // Validate all input fields and check for duplicate usernames.
            if (!isWarehouseFull()) {

                // Prepare the SQL UPDATE statement.
                String prepSQL = "INSERT INTO transfer Values (CURRENT_TIMESTAMP" +
                ", '" + user.username +
                "', " + cmbProduct.getSelectedItem().toString() + 
                ", " + Integer.toString(wareID) +
                ", " + cmbWarehouse.getSelectedItem().toString() +
                ", " + rs5.getString("quantity") +
                ")";

                String prepSQL1 = "UPDATE stores SET warehouseID = " + cmbWarehouse.getSelectedItem().toString()+
                " WHERE productID = " +  cmbProduct.getSelectedItem().toString();

                
                // Execute the prepared SQL statement.
                int result = dbCon.executePrepared(prepSQL);
                int result1 = dbCon.executePrepared(prepSQL1);
                
                // Check the result and provide appropriate feedback to the user.
                if (result > 0 && result1 > 0) {
                    javax.swing.JLabel label = new javax.swing.JLabel("Product transfered successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    javax.swing.JLabel label = new javax.swing.JLabel("Error...");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                // If validation fails, inform the user about the validation errors.
                javax.swing.JLabel label = new javax.swing.JLabel("Not enough capacity in the destination warehouse");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            // Catch SQL exceptions and show an error message to the user.
            JOptionPane.showMessageDialog(null, "Error transfer product." + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cmbProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductActionPerformed
        // TODO add your handling code here:
        updateFields();
    }//GEN-LAST:event_cmbProductActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbProduct;
    private javax.swing.JComboBox<String> cmbWarehouse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
