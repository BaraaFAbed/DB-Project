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
public class UpdateDeleteWarehouse extends javax.swing.JFrame {

    /**
     * Creates new form UpdateDeleteWarehouse
     */
    
    // Instance variables
    myDBCon dbCon;              // Database connection object
    ResultSet rs;               // Result set for account data
    ResultSet rsCheck;          // Result Set for warehouse capacity data
    LoginUser user;             // Stores currently logged in user
    String ogUsername;          // Stores the username of the currently shown employee
    EncryptionMD5 md5;  
    
    public UpdateDeleteWarehouse() {
        // Initializes GUI components created using the form editor in NetBeans or similar IDE
        initComponents();
        
        // creating connection
        dbCon = new myDBCon();
        
        // Positions this JFrame to the center of the screen
        this.setLocationRelativeTo(null);
        
        // set all error labels to invisible
        lblIDError.setVisible(false);
        lblLocationError.setVisible(false);
        lblCapacityError.setVisible(false);

        
        // Fetch and display new data from the database to populate the form
        getNewData();
    }
    
    // This method fetches and sets the data from the database to populate the form's fields
    private void getNewData() {

        try {
            // Query to fetch account details of employees
            rs = dbCon.executeStatement("SELECT warehouseID, location, capacity FROM warehouse ORDER BY WarehouseID ASC ");
            
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

        jLabel8 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        lblIDError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCapacityError = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblLocationError = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("ID:");

        txtCapacity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacityActionPerformed(evt);
            }
        });

        lblIDError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblIDError.setForeground(new java.awt.Color(255, 0, 0));
        lblIDError.setText("error label");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Update/Delete Warehouse");

        lblCapacityError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblCapacityError.setForeground(new java.awt.Color(255, 0, 0));
        lblCapacityError.setText("error label");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtID.setEnabled(false);

        txtLocation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLocation.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Location:");

        lblLocationError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblLocationError.setForeground(new java.awt.Color(255, 0, 0));
        lblLocationError.setText("error label");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Capacity:");

        btnUpdate.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnNext.setText("Next >>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnPrevious.setText("<< Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtID)
                    .addComponent(txtLocation))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIDError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLocationError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCapacityError, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addGap(179, 179, 179))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocationError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblCapacityError)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populateFields() {
        try {
            // Setting form fields with the current row's data from the result set.
            txtID.setText(rs.getString("warehouseID"));
            txtLocation.setText(rs.getString("location"));
            txtCapacity.setText(rs.getString("Capacity"));
            
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
    
    void clearErrorLabels() {
        // erase error label text and set visibility to false
        lblIDError.setText("");
        lblIDError.setVisible(false);
        lblLocationError.setText("");
        lblLocationError.setVisible(false);
        lblCapacityError.setText("");
        lblCapacityError.setVisible(false);
    }
    
    /**
    * This method checks if the provided string can be parsed as an integer.
    * @param s The string to check.
    * @return true if the string can be parsed as an integer, false otherwise.
    */
   public boolean isInteger(String s) {
       try {
           Integer.parseInt(s);
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }

   /**
    * This method checks if the provided string can be parsed as a double.
    * @param s The string to check.
    * @return true if the string can be parsed as a double, false otherwise.
    */
   public boolean isDouble(String s) {
       try {
           Double.parseDouble(s);
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }
   
   private boolean isDuplicate(String ID) throws SQLException {
        String stmtSQL = "SELECT warehouseID FROM warehouse WHERE warehouseID = " + ID.trim();
        rs = dbCon.executeStatement(stmtSQL);

        if (rs.isBeforeFirst()) lblIDError.setText("ID already taken.");
        lblIDError.setVisible(true);
        
        // Check if the resultset has data which indicates a duplicate
        return rs.isBeforeFirst();
    }
   
   boolean isValidData() {
       boolean result = true;
       
       // clears error labels
       clearErrorLabels();

       // Check if ID is empty or negative or not Int
       if (txtCapacity.getText().trim().isEmpty() || !isInteger(txtCapacity.getText().trim()) || Integer.parseInt(txtCapacity.getText().trim()) < 0 ) {
           if (txtCapacity.getText().trim().isEmpty()) {
               lblCapacityError.setText("Invalid. Cannot be empty.");
           } else if (!isInteger(txtCapacity.getText().trim()) || Integer.parseInt(txtCapacity.getText().trim()) < 0) {
               lblCapacityError.setText("Invalid. Must be a 5 digit positive number.");
           }
           lblCapacityError.setVisible(true);
           result = false;
       }
       
       return result;
   }
    
    private void txtCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacityActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Prompt the user for confirmation before proceeding with the update.
        int returnValue = JOptionPane.showConfirmDialog(this, "Are you sure you want to update?", "Warning", JOptionPane.YES_NO_OPTION);
        if (returnValue != JOptionPane.YES_OPTION) {
            return;  // Exit the method if user selects "No"
        }

        try {
            // Validate all input fields and check for duplicate usernames.
            if (isValidData()) {
                // Prepare the SQL UPDATE statement.
                String prepSQL = "UPDATE warehouse SET capacity = " + txtCapacity.getText().trim() + " WHERE warehouseID = " + txtID.getText().trim();
                
                // Getting used capacity of the warehouse
                String prepSQL3 = "SELECT SUM(\"Size\" * Quantity) AS UsedCapacity FROM stores S JOIN product P ON S.ProductID = P.ProductID WHERE WarehouseID = " + txtID.getText().trim();
                
                //Check if capacity is valid
                rsCheck = dbCon.executeStatement(prepSQL3);
                rsCheck.next();
                if (rsCheck.getInt("UsedCapacity") > Integer.parseInt(txtCapacity.getText().trim())) {
                    javax.swing.JLabel label = new javax.swing.JLabel("Error... Updated capacity is less than the current capacity.");
                    return; // exit function
                }
                
                // Execute the prepared SQL statement.
                int result = dbCon.executePrepared(prepSQL);

                // Check the result and provide appropriate feedback to the user.
                if (result > 0) {
                    javax.swing.JLabel label = new javax.swing.JLabel("Warehouse " + txtID.getText().trim() + " updated successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    getNewData();  // Refresh the data
                } else {
                    javax.swing.JLabel label = new javax.swing.JLabel("Warehouse not updated. Please fix validation errors...");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                // If validation fails, inform the user about the validation errors.
                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            // Catch SQL exceptions and show an error message to the user.
            JOptionPane.showMessageDialog(null, "Error updating Warehouse." + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        MoveNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        MovePrevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCapacityError;
    private javax.swing.JLabel lblIDError;
    private javax.swing.JLabel lblLocationError;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLocation;
    // End of variables declaration//GEN-END:variables
}
