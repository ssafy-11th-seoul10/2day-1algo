{\rtf1\ansi\ansicpg949\cocoartf2761
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 -- \uc0\u53076 \u46300 \u47484  \u51089 \u49457 \u54644 \u51452 \u49464 \u50836 \
SELECT\
    EMP_NO, EMP_NAME,\
    CASE\
        WHEN SCORE >= 96 THEN "S"\
        WHEN SCORE < 96 AND SCORE >= 90 THEN "A"\
        WHEN SCORE < 90 AND SCORE >= 80 THEN "B"\
        ELSE "C"\
    END AS GRADE,\
    CASE\
        WHEN SCORE >= 96 THEN SAL * 0.2\
        WHEN SCORE < 96 AND SCORE >= 90 THEN SAL * 0.15\
        WHEN SCORE < 90 AND SCORE >= 80 THEN SAL * 0.1\
       ELSE 0\
    END AS BONUS\
\
    FROM(\
        SELECT A.EMP_NO AS EMP_NO, AVG(SCORE) AS SCORE,\
            EMP_NAME, AVG(SAL) AS SAL\
        FROM HR_EMPLOYEES AS A\
        JOIN HR_GRADE AS B\
        ON A.EMP_NO = B.EMP_NO\
        \
        GROUP BY A.EMP_NO\
        ) AS C\
        ORDER BY EMP_NO;}