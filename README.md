radar-livre-coletor
===================

Implementação do Coletor do Projeto de Atualização da Monitoração Aeronáutica e Auto-Sustentabilidade da UFC, Campus Quixadá.

Necessita de um banco de dados PostgreSQL com as seguintes informações:
Nome do banco: radar-livre-coletor
Login: postgres
Senha: postgres

Rode a classe Cliente como Java application para que o coletor se conecte à porta 30003, caso essa porta ainda não esteja aberta pelo ADSBOX e você deseje fazer apenas uma simulação rode antes a classe Servidor, também como Java application, e envie mensagens no formato ADS-B por este servidor.
