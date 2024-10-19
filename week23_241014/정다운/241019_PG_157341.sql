-- 코드를 입력하세요
SELECT DISTINCT(A.CAR_ID)
    
    FROM CAR_RENTAL_COMPANY_CAR AS A
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS B
    ON A.CAR_ID = B.CAR_ID
    
    WHERE CAR_TYPE LIKE "세단" AND
        MONTH(START_DATE) >= 10
    ORDER BY CAR_ID DESC
    ;