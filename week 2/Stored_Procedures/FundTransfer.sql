CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_target_account_id IN NUMBER,
    p_transfer_amount IN NUMBER
)
IS
    v_source_balance NUMBER(10, 2);
BEGIN
    SELECT balance INTO v_source_balance
    FROM accounts
    WHERE account_id = p_source_account_id;

    IF v_source_balance >= p_transfer_amount THEN
        UPDATE accounts SET balance = balance - p_transfer_amount
        WHERE account_id = p_source_account_id;
        
        UPDATE accounts SET balance = balance + p_transfer_amount
        WHERE account_id = p_target_account_id;
        
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer completed.');
    ELSE
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFunds;
/
