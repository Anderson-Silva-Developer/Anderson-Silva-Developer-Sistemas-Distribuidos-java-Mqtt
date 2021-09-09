package clientSub;
import comunication.Comunication;
import conection.Conection;
import midiaFile.MidiaFile;


public class ClientSub {
    private  String clientId;
    private Conection conection;
    private Comunication comunication;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Conection getConection() {
        return conection;
    }

    public void setConection(Conection conection) {
        this.conection = conection;
    }

    public Comunication getComunication() {
        return comunication;
    }

    public void setComunication(Comunication comunication) {
        this.comunication = comunication;
    }


    private ClientSub(String clientId, Conection conection, Comunication comunication) {
        this.clientId = clientId;
        this.conection = conection;
        this.comunication = comunication;

    }
    public static class ClientSubBuilder{
        private  String clientId;
        private Conection conection;
        private Comunication comunication;


        public ClientSubBuilder(String clientId, Conection conection, Comunication comunication) {
            this.clientId = clientId;
            this.conection = conection;
            this.comunication = comunication;

        }
        public ClientSubBuilder clientId(String clientId){
            this.clientId=clientId;
            return this;
        }
        public ClientSubBuilder conection(Conection conection){
            this.conection=conection;
            return this;
        }
        public ClientSubBuilder comunication(Comunication comunication){
            this.comunication=comunication;
            return this;
        }

        public ClientSub createClientSub(){
            return new ClientSub(clientId,conection,comunication);

        }




    }
}
