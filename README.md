
# Envido de Emails

Microsserviço para envido de emails.


## Funcionalidades

- Microsserviço
- Envio automatizado de emails



## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/CleuJunior/ms-mail.git
```

Entre no diretório do projeto

```bash
  cd ms-mail
```

URI Local
```http
  http://localhost:8080
```





## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente.

`DATA_BASE_URL`

`EMAIL_PASSWORD`

`USER_DATABASE`

`ANOTHER_API_KEY`

`USER_DATABASE_PASSWORD`

`USER_NAME_EMAIL`

`MQ_ADDRESS`





## Documentação da API

#### Envia um e-mail automático.

```http
  POST /seding-email
```

#### Body
#### Content-Type: application/json


| Parâmetro   | Tipo     | Descrição                             | Obrigatório |        
|:------------|:---------|:--------------------------------------|:------------|
| `ownerRef`  | `string` | Referencia de proprietário do e-mail. | **SIM**     |
| `emailFrom` | `string` | E-mail de quem enviou.                | **SIM**     |
| `emailTo`   | `string` | E-mail para quem foi enviado.         | **SIM**     |
| `subject`   | `string` | Assunto do e-mail.                    | **SIM**     |
| `text`      | `string` | Corpo do e-mail.                      | **SIM**     |


Retorna como resposta um EmailModel com o status do e-mail do Enum StatusEmail caso a requisição seja enviada 
corretamente ou algum problema de envio tenha ocorrido.



## Aprendizados

- Introdução a Microsserviços
- Uso de Variáveis de Ambiente
- Uso de Validations com Spring Boot
- JavaMailSender
