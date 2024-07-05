WITH RECURSIVE GENDATA AS (
    SELECT ID, PARENT_ID, 1 as GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID is NULL
    
    UNION ALL 
    
    SELECT ECOLI_DATA.ID, ECOLI_DATA.PARENT_ID, (GENERATION + 1) as GENERATION
    FROM  ECOLI_DATA
    JOIN GENDATA
    on GENDATA.ID = ECOLI_DATA.PARENT_ID
    
)

SELECT COUNT(*) as COUNT, GENERATION
FROM GENDATA
WHERE ID NOT IN (
    SELECT PARENT_ID
    FROM GENDATA
    WHERE PARENT_ID is NOT NULL
)
GROUP BY GENERATION;