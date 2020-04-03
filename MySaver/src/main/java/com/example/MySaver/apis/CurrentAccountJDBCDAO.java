/*package com.example.MySaver.apis;

public class CurrentAccountJDBCDAO implements Dao<CurrentAccount> {
    
    
    public static void main(String[] args) {
        
        
        
        
    }
    
    public String url = "jdbc:mysql://localhost:3306/mysaverapplication";
    public String password = "root";
    public String user = "root";
    
    @Override
    public CurrentAccount add(CurrentAccount newCurrentAccount ) {
        //loading database Driver
    
    try(Connection myconnection =DriverManager.getConnection(url, user, password)){
        String insertSQL = "INSERT INTO currentaccount values(?,?,?,?,?)";
        PreparedStatement psInsert = myconnection.prepareStatement(insertSQL);
        psInsert.setInt(1,newCurrentAccount.getCurrentAccountNumber());
        psInsert.setInt(2,newCurrentAccount.getCurrentAccountSortCode());
        psInsert.setString(3,newCurrentAccount.getCurrentAccountExpirationDate());
        psInsert.setDouble(4,newCurrentAccount.getAvailableBalance());
        psInsert.setDouble(5, newCurrentAccount.getArrangedOverdraft());
        psInsert.executeUpdate();
    
    }
    catch(Exception exception) {
        exception.printStackTrace();
    }
    return null;
    }

 


        
    @Override
    public CurrentAccount find(int currentAccountId) {
        // 1. loading the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
    }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        // 2. Connecting to the DB
        try(Connection myconnection = 
                DriverManager.getConnection(url,user,password)) {
        // 3. Fetching from database
        // select query for fetch currentAccount by currentAccountId
            String selectSQL = "Select * from currentaccount where currentAccountId=?";
        // ? = placeholder for content
        // Prepare state is used for pre writing out an sql query to be fired
        PreparedStatement psSelect = myconnection.prepareStatement(selectSQL);
        psSelect.setInt(1, currentAccountId);
        // execute query is used to fetch details 
        ResultSet resultSetCurrentAccount = psSelect.executeQuery();
        if(resultSetCurrentAccount.next()) {
            CurrentAccount cur = new CurrentAccount();
            cur.setArrangedOverdraft(resultSetCurrentAccount.getDouble(20));
            cur.setAvailableBalance(resultSetCurrentAccount.getDouble(600));
            cur.setCurrentAccountExpirationDate(resultSetCurrentAccount.getString("12/22"));
            cur.setCurrentAccountNumber(resultSetCurrentAccount.getInt(1298889991));
            cur.setCurrentAccountSortCode(resultSetCurrentAccount.getInt(129199));
            
            
        }
        }
        
        catch(Exception exception) {
            exception.printStackTrace();
        }
        return null;
            
}
    @Override
    public CurrentAccount delete(CurrentAccount selectedcurrentAccount) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public CurrentAccount update(CurrentAccount modifiedcurrentAccount) {
        // TODO Auto-generated method stub
        return null;
    }
    
    }

 */