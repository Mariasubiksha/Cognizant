DECLARE
    CURSOR cur_vip_candidates IS
        SELECT customer_id
        FROM customers
        WHERE balance > 10000;

BEGIN
    FOR rec IN cur_vip_candidates LOOP
        UPDATE customers
        SET isvip = 'TRUE'
        WHERE customer_id = rec.customer_id;
    END LOOP;

    COMMIT;
END;
/
