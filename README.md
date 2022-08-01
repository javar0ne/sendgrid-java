# SendGrid Java
This is a basic spring boot application which enables you to send email via SendGrid.

### Configuration
In order to be able to send email via SendGrid, generate an API key and put it in the *application.properties* replacing the value of the key *send-grid.api.key*.

If ssl is required:
- place the key store under *src/main/resources/static* and add to the key *server.ssl.key-store* value the key store name in the *application.properties*.
- replace the key *server.ssl.key-store-password* value with the keystore password in the *application.properties*.
- replay the key *server.ssl.key-alias* value with key alias in the *application.properties*. 

Otherwhise, just set the key *server.ssl.enabled* value to *false*.
