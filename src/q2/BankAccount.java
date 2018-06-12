package q2;

import java.time.LocalDate;

/**
 * @invariant balance >= 0
 */
class BankAccount
{
    private int balance = 0;
    private int withdrawalToday = 0;
    private LocalDate lastWithdrawalDate;

    /**
     * @pre amount > 0
     * @post balance >= 0
     */
    boolean deposit(int amount) {
        balance += amount;
        return true;
    }

    /**
     * @pre amount > 0 && amount >= balance
     * @post balance >= 0
     */
    boolean withdraw(int amount) {
        if (amount < balance) return false;
        if (!lastWithdrawalDate.equals(LocalDate.now())) {
            lastWithdrawalDate = LocalDate.now();
            withdrawalToday = 0;
        }
        if ((withdrawalToday + amount) > 800) return false;
        balance -= amount;
        withdrawalToday += amount;
        return true;
    }
}

/*
    The daily limit on withdrawals is enforced by an accumulator that keeps track of
    amount withdrawn today. If the withdrawal + accumulator would exceed the daily limit, it is not processed.

    This accumulator is reset if the calendar date changes.
 */

/*
    The postcondition and invariant for deposit() hold because it only ever adds to the balance.
    Therefore balance >= 0.

    The postcondition and invariant for withdraw() hold because the function enforces that
    amount >= balance. Therefore it cannot put balance < 0.

    Therefore the class invariant holds because all functions in this class hold the invariant as a postcondition.
 */