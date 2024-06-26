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
public class EditCustomer extends javax.swing.JFrame {

    // Instance variables
    myDBCon dbCon;              // Database connection object
    ResultSet rs;               // Result set for account data
    LoginUser user;             // Stores currently logged in user
    String ogUsername;          // Stores the username of the currently shown employee
    EncryptionMD5 md5;         // Stores MD5 hasher
    Menu menu;
    
    /**
     * Creates new form EditCustomer
     */
    public EditCustomer(LoginUser _user, Menu _menu) {
        // Initializes GUI components created using the form editor in NetBeans or similar IDE
        initComponents();
        
        // Getting menu instance
        menu = _menu;
        
        // Getting MD5 instance
        md5 = EncryptionMD5.getInstance();
        
        // getting user
        user = _user;
        
        // creating connection
        dbCon = new myDBCon();
        
        // Positions this JFrame to the center of the screen
        this.setLocationRelativeTo(null);
        
        // set all error labels to invisible
        lblUsernameError.setVisible(false);
        lblEmailError.setVisible(false);
        lblPasswordError.setVisible(false);
        lblConfirmPasswordError.setVisible(false);
        lblNameError.setVisible(false);
        lblBudgetError.setVisible(false);

        // Initialize the database connection
        dbCon = new myDBCon();
        
        // Fetch and display new data from the database to populate the form
        getNewData();
    }
    
    // This method fetches and sets the data from the database to populate the form's fields
    private void getNewData() {

        try {
            // Query to fetch account details of employees
            rs = dbCon.executeStatement("SELECT A.name, A.username, A.email, E.budget FROM account A, customer E WHERE A.username = E.username AND A.username = '" + user.username + "' ORDER BY A.name ASC ");
            
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

        lblBudgetError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblUsernameError = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNameError = new javax.swing.JLabel();
        txtBudget = new javax.swing.JTextField();
        lblEmailError = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        lblConfirmPasswordError = new javax.swing.JLabel();
        ToggleConfirmPasswordBtn = new javax.swing.JToggleButton();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        TogglePasswordBtn = new javax.swing.JToggleButton();
        lblPasswordError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblBudgetError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblBudgetError.setForeground(new java.awt.Color(255, 0, 0));
        lblBudgetError.setText("error label");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password:");

        lblUsernameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblUsernameError.setForeground(new java.awt.Color(255, 0, 0));
        lblUsernameError.setText("error label");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Email:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Name:");

        lblNameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(255, 0, 0));
        lblNameError.setText("error label");

        txtBudget.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBudgetActionPerformed(evt);
            }
        });

        lblEmailError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmailError.setText("error label");

        txtConfirmPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Confirm Password:");

        lblConfirmPasswordError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblConfirmPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblConfirmPasswordError.setText("error label");

        ToggleConfirmPasswordBtn.setBackground(new java.awt.Color(255, 255, 255));
        ToggleConfirmPasswordBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cmp320project/SeePwdResized.png"))); // NOI18N
        ToggleConfirmPasswordBtn.setToolTipText("Show password");
        ToggleConfirmPasswordBtn.setMinimumSize(new java.awt.Dimension(522, 523));
        ToggleConfirmPasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToggleConfirmPasswordBtnActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Update/Delete Account");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Username:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Budget:");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        TogglePasswordBtn.setBackground(new java.awt.Color(255, 255, 255));
        TogglePasswordBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cmp320project/SeePwdResized.png"))); // NOI18N
        TogglePasswordBtn.setToolTipText("Show password");
        TogglePasswordBtn.setMinimumSize(new java.awt.Dimension(522, 523));
        TogglePasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TogglePasswordBtnActionPerformed(evt);
            }
        });

        lblPasswordError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblPasswordError.setForeground(new java.awt.Color(255, 0, 0));
        lblPasswordError.setText("error label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TogglePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ToggleConfirmPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblConfirmPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail)
                                    .addComponent(txtName)
                                    .addComponent(txtUsername)
                                    .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblNameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblUsernameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblEmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblBudgetError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(btnUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsernameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblEmailError)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblBudgetError)
                    .addComponent(txtBudget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPasswordError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TogglePasswordBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ToggleConfirmPasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblConfirmPasswordError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populateFields() {
        try {
            // Setting form fields with the current row's data from the result set.
            txtName.setText(rs.getString("name"));
            ogUsername = rs.getString("username");
            txtUsername.setText(rs.getString("username"));
            txtEmail.setText(rs.getString("email"));
            txtPassword.setText("");
            txtConfirmPassword.setText("");
            txtBudget.setText(rs.getString("budget"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * This method clears all error labels on the form.
    */
   void clearErrorLabels() {
        // erase error label text and set visibility to false
        lblUsernameError.setText("");
        lblUsernameError.setVisible(false);
        lblPasswordError.setText("");
        lblPasswordError.setVisible(false);
        lblConfirmPasswordError.setText("");
        lblConfirmPasswordError.setVisible(false);
        lblNameError.setText("");
        lblNameError.setVisible(false);
        lblEmailError.setText("");
        lblEmailError.setVisible(false);
        lblBudgetError.setText("");
        lblBudgetError.setVisible(false);
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

   /**
    * Validates if the entered password and its confirmation match and are not empty.
    *
    * @return true if the password is valid, otherwise false.
    */
    boolean isValidPassword() {
       boolean result = true; 

       // Check if password is empty
       if (txtPassword.getText().trim().isEmpty()) {
           lblPasswordError.setText("Invalid. Cannot be empty.");
           lblPasswordError.setVisible(true);
           result = false;
       }

       // Check if confirmation matches the password
       if (!txtConfirmPassword.getText().trim().equals(txtPassword.getText().trim())) {
           lblConfirmPasswordError.setText("Invalid. Password does not match.");
           lblConfirmPasswordError.setVisible(true);
           result = false;
       }

       return result;
   }
    
    /**
    * Checks if a username already exists in the database.
    *
    * @param username The username to check for duplicates.
    * @return true if the username already exists, otherwise false.
    * @throws SQLException If there's an error executing the SQL query.
    */
    private boolean isDuplicate(String username) throws SQLException {
        String stmtSQL = "SELECT username FROM account WHERE username = '" + username.toLowerCase()+ "'";
        rs = dbCon.executeStatement(stmtSQL);

        
        // Check if the resultset has data which indicates a duplicate
        return rs.isBeforeFirst();
    }
   
   /**
    * This method validates the data entered in the form.
    * @return true if all data is valid, false if any data is invalid.
    */
   boolean isValidData() {
       boolean result = true;

       // Check if name is empty or too long
       if (txtName.getText().trim().isEmpty() || (txtName.getText().trim().length() > 20)) {
           if (txtName.getText().trim().isEmpty()) {
               lblNameError.setText("Invalid. Cannot be empty.");
           } else if (txtName.getText().trim().length() > 20) {
               lblNameError.setText("Invalid. Must be < 21 chars.");
           }
           lblNameError.setVisible(true);
           result = false;
       }

       // Check if username is empty or too long
       if (txtUsername.getText().trim().isEmpty() || (txtUsername.getText().trim().length() > 30)) {
           if (txtUsername.getText().trim().isEmpty()) {
               lblUsernameError.setText("Invalid. Cannot be empty.");
           } else if (txtUsername.getText().trim().length() > 30) {
               lblUsernameError.setText("Invalid. Must be < 31 chars.");
           }
           lblUsernameError.setVisible(true);
           result = false;
       }
       
       // Check if email is too long
       if (txtEmail.getText().trim().length() > 30) {
           if (txtEmail.getText().trim().length() > 30) {
               lblUsernameError.setText("Invalid. Must be < 31 chars.");
           }
           lblEmailError.setVisible(true);
           result = false;
       }
       
       // Check if Budget is empty or out of range or not a number
       if (txtBudget.getText().trim().isEmpty() || !(isInteger(txtBudget.getText().trim()) || isDouble(txtBudget.getText().trim())) || (Double.parseDouble(txtBudget.getText().trim()) < 0 || Double.parseDouble(txtBudget.getText().trim()) > 999999999.99 )) {
           if (txtBudget.getText().trim().isEmpty()) {
               lblBudgetError.setText("Invalid. Cannot be empty.");
           } else if (!(isInteger(txtBudget.getText().trim()) || isDouble(txtBudget.getText().trim()))) {
               lblBudgetError.setText("Invalid. Must be a number.");
           } else if ((Double.parseDouble(txtBudget.getText().trim()) < 0 || Double.parseDouble(txtBudget.getText().trim()) > 999999999.99 )) {
               lblBudgetError.setText("Invalid. Must be a positive number less then 1,000,000,000.");
           } 
           lblBudgetError.setVisible(true);
           result = false;
       }

       return result;
   }

   /**
    * Validates all the user input fields.
    *
    * @return true if all entered data is valid, otherwise false.
    */
   boolean isValidAll() {
       clearErrorLabels();
       boolean result = isValidData();

       // Ensure both data and password are valid
       return isValidPassword() && result;
   }
    
    
    
    private void txtBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBudgetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBudgetActionPerformed

    private void ToggleConfirmPasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToggleConfirmPasswordBtnActionPerformed
        // Check if the toggle button is selected.
        if (ToggleConfirmPasswordBtn.isSelected())
        {
            // If the toggle button is selected, set the echo characters of the password and confirm password fields to 0.
            // This effectively makes the characters in these fields visible.
            txtConfirmPassword.setEchoChar((char)0);
        }
        else
        {
            // If the toggle button is not selected, set the echo characters of the password and confirm password fields to '•'.
            // This hides the characters in these fields, replacing them with '•' symbols.
            txtConfirmPassword.setEchoChar('•');
        }
    }//GEN-LAST:event_ToggleConfirmPasswordBtnActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Prompt the user for confirmation before proceeding with the update.
        int returnValue = JOptionPane.showConfirmDialog(this, "Are you sure you want to update?", "Warning", JOptionPane.YES_NO_OPTION);
        if (returnValue != JOptionPane.YES_OPTION) {
            return;  // Exit the method if user selects "No"
        }

        try {
            // Validate all input fields and check for duplicate usernames.
            if (isValidAll() && (!isDuplicate(txtUsername.getText().trim()) || ogUsername.equalsIgnoreCase(txtUsername.getText()))) {

                // Prepare the SQL UPDATE statement.
                String prepSQL = "UPDATE account SET name = '" + txtName.getText().trim() +
                "', username = '" + txtUsername.getText().trim() +
                "', password = '" + md5.getMD5(txtPassword.getText().trim()) +  // Using MD5 for password, though not the safest.
                "', email = '" + txtEmail.getText() +
                "' WHERE username = '" + ogUsername + "'";

                String prepSQL1 = "UPDATE customer SET budget = " + txtBudget.getText() +
                " WHERE username = '" + ogUsername + "'";

                // Execute the prepared SQL statement.
                int result = dbCon.executePrepared(prepSQL);
                int result1 = dbCon.executePrepared(prepSQL1);

                // Check the result and provide appropriate feedback to the user.
                if (result > 0 && result1 > 0) {
                    javax.swing.JLabel label = new javax.swing.JLabel("User " + ogUsername + " updated successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    getNewData();  // Refresh the data
                } else {
                    javax.swing.JLabel label = new javax.swing.JLabel("User not updated. Please fix validation errors...");
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
            JOptionPane.showMessageDialog(null, "Error updating user." + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void TogglePasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TogglePasswordBtnActionPerformed

        // Check if the toggle button is selected.
        if (TogglePasswordBtn.isSelected())
        {
            // If the toggle button is selected, set the echo characters of the password and confirm password fields to 0.
            // This effectively makes the characters in these fields visible.
            txtPassword.setEchoChar((char)0);
        }
        else
        {
            // If the toggle button is not selected, set the echo characters of the password and confirm password fields to '•'.
            // This hides the characters in these fields, replacing them with '•' symbols.
            txtPassword.setEchoChar('•');
        }
    }//GEN-LAST:event_TogglePasswordBtnActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ToggleConfirmPasswordBtn;
    private javax.swing.JToggleButton TogglePasswordBtn;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblBudgetError;
    private javax.swing.JLabel lblConfirmPasswordError;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblUsernameError;
    private javax.swing.JTextField txtBudget;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
