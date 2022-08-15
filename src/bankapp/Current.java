package bankapp;

@SuppressWarnings("serial")
public class Current extends Account{
    
    Current(int accountNumber, double initialDeposit){
        super(accountNumber);
        this.setBalance(initialDeposit);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.Current;
    }
}
