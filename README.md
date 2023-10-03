# Olá, seja bem-vindo(a) ao Stimulus!

###### Repositório para a disciplina de "Programação Web" do curso BSI - 2023

[![Build Status](https://travis-ci.org/condessalovelace/mavenquickstart.svg?branch=master)](https://travis-ci.org/condessalovelace/mavenquickstart) 
![Quality Gate](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Quality Gate](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

**Stimulus** é uma aplicação utilizada para o tratamento, armazenamento e compartilhamento de arquivos de mídia dentro de um sistema flexível e estimulante. Fornecemos aos usuários um ambiente no qual podem compartilhar os seus vídeos pessoais, imagens engraçadas, fotos dos seus pets fofinhos, suas obras de artes e muito mais! **Não pense no limite, apenas estimule-se!**

### Requisitos

| **Dependência**  | **Versão** |
|------------------|------------|
| Java             | 17         |
| JDK              | 1.8.0_381  |
| Maven            | 4.0.0      |
| h2               | 2.1.214    |
| springdoc-openapi| 2.1.0      |
| Spring Tool      | 4.4.18.1   |

### Baixar o projeto
```cmd
git clone https://github.com/CleitonJB/PW-Stimulus
cd PW-Stimulus
```

### Instalar as depêndencias do projeto
##### 1º Passo
Execute a ferramenta "Spring Tool Suite".

##### 2º Passo
No menu superior da ferramenta, selecione: **File > Open Projects from File System...**; Busque pelo repositório baixado e o selecione para que seja aberto na plataforma.

##### 3º Passo
Após confirmar as pastas a serem construídas, você deve visualizar a hierarquia de pastas e arquivos do projeto.

Clique na seta ("**>**") ao lado do Projeto "Stimulus" para que as pastas sejam mostradas.

##### 4º Passo
Localize o arquivo denominado **"pom.xml"** (último arquivo da hierarquia), clique nele com o botão direito do mouse, vá até a opção **"Run as"** e selecione a opção **"Maven install"**

##### 5º Passo
Após o termino do processo, basta executar o projeto da seguinte maneira:
    - Clique sobre a pasta raiz do projeto **"Stimulus"**
    - Vá novamente até a opção **"Run as"**
    - Selecione a opção **"Spring Boot App"**

### Endpoints da aplicação

#### Gerais

As **rotas gerais** são utilizadas para controle e gerenciamento da aplicação como um todo e não representam funcionalidades e serviços fornecidos pela mesma.

Todas as rotas gerais são acessadas a partir do endereço: **http://localhost:8080**

| **Endpoint**               | **Descrição** |
|----------------------------|---------------|
| **/api-docs**              | Acesso aos dados da implementação do springdoc-openapi |
| **/swagger-ui/index.html** | Interface de usuário para as rotas da aplicação        |
| **/h2-console**            | Banco de dados local utilizado na aplicação            |

#### Serviços
cri... cri... cri...

### Licença
Use, mas não abuse :)