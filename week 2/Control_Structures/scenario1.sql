DECLARE
    CURSOR cur_customers IS
        SELECT customer_id, loan_interest_rate
        FROM customers
        WHERE age > 60;

BEGIN
    FOR rec IN cur_customers LOOP
        UPDATE customers
        SET loan_interest_rate = loan_interest_rate - 0.01
        WHERE customer_id = rec.customer_id;
    END LOOP;

    COMMIT;
END;

