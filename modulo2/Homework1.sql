CREATE TABLE VEM_SER.ESTUDANTE (
id_estudante NUMBER NOT NULL,
nome VARCHAR2(200) NOT NULL,
data_nascimento DATE NOT NULL,
Nr_matricula NUMBER(10) NOT NULL,
ativo VARCHAR2(200) NOT NULL,
PRIMARY KEY(id_estudante)
);
CREATE SEQUENCE seq_estudante
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'ADRIELE BEATRIZ SOUZA DOS SANTOS',
TO_DATE('30-03-1998',
'dd-mm-yyyy'), '217116015', 'S');
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'DANIEL DOS SANTOS',
TO_DATE('27-05-1953',
'dd-mm-yyyy'), '21711786', 'S');
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'DENE DOS SANTOS',
TO_DATE('19-07-1967',
'dd-mm-yyyy'), '21711797', 'S');
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'ADRIANE LOPES',
TO_DATE('20-02-1992',
'dd-mm-yyyy'), '21711775', 'S');
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'DENILSON DOS SANTOS',
TO_DATE('13-02-1991',
'dd-mm-yyyy'), '21711756', 'S');
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'DENISE DOS SANTOS FREITAS',
TO_DATE('30-06-1989',
'dd-mm-yyyy'), '21711726', 'S');
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'MIGUEL CAUN DOS SANTOS ALMEIDA',
TO_DATE('23-09-2000',
'dd-mm-yyyy'), '21711785', 'S');
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'RICHARD DOS SANTOS FREITAS',
TO_DATE('19-08-2005',
'dd-mm-yyyy'), '217117915', 'S');
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'EVELYN DOS SANTOS FREITAS',
TO_DATE('31-08-2008',
'dd-mm-yyyy'), '21711771', 'S');
INSERT INTO VEM_SER.ESTUDANTE
(ID_ESTUDANTE, NOME, DATA_NASCIMENTO, NR_MATRICULA,
ATIVO)
VALUES(SEQ_ESTUDANTE.nextval, 'HEITOR DOS SANTOS LOPES',
TO_DATE('13-11-2010',
'dd-mm-yyyy'), '21711783', 'S');
SELECT ID_ESTUDANTE,  NOME FROM VEM_SER.ESTUDANTE