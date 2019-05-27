# DESAFIO HBSIS

Aplicação desenvolvida para cadastro e pesquisa de informações.

# É necessário ter instalado 

WampServer e Heidi Sql
Java 1.8
Eclipse

# Para rodar localmente

Abrir o WampServer para rodar o banco localmente. 
Abri o HeidiSQL e colocar as seguintes configurações:
- Tipo de rede: MySQL (TCP/IP)
- Servidor/IP: localhost
- Usuário: root
- Porta: 3306

Na aba consulta cole:
- create database desafio;

Depois aperte F9, clique na caixa a esquerda fora da aba consulta e aperte F5. A base desafio deve aparecer do lado esquerdo.
Selecione desafio, volte na aba consulta e cole:
- create table cidades(
	id_cidade int not null auto_increment,
	nome_cidade varchar(50) not null,
	pais_cidade varchar(5) not null,
	primary key (id_cidade));

Depois aperte F9.

Abra o eclipse, clique em Launch, na aba File -> Import -> Git -> Projects from git -> Clone URI e no campo URI cole:
- https://github.com/BiancaKJ/desafioHBSIS

Clique em Next -> Next -> Next -> Next -> Finish.
Abra o projeto desafioHBSIS -> src/main/java -> pacote com.desafio.
Clique com o botão direito na classe TempoApplication.java -> Run As -> Java Application.

Abra o browser, escreva localhost:8080 e divirta-se.

