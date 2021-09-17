public class ControleRemoto implements Controlador {
    private int volume;
    private boolean ligado;
    private boolean tocando;

    public void getTela(){
        System.out.println("--------------------------------------");
            if (this.getLigado()){
                System.out.println("Disponivel Ligado!");
                System.out.println("Volume: " + this.getVolume());
                if (this.getTocando()){
                    System.out.println("Disponivel está tocando!");
                }
                else {
                    System.out.println("Disponivel não está tocando!");
                }
            }
            else {
                System.out.println("Disponivel Desligado!");
            }
        System.out.println("--------------------------------------");
    }

    public ControleRemoto(){
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }

    private int getVolume(){
        return volume;
    }

    private void setVolume(int volume){
        this.volume = volume;
    }

    private boolean getLigado(){
        return ligado;
    }

    private void setLigado(boolean ligado){
        this.ligado = ligado;
    }

    private boolean getTocando(){
        return tocando;
    }

    private void setTocando(boolean tocando){
        this.tocando = tocando;
    }


    @Override
    public void ligar() {
       this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        if(this.getLigado()) {
            System.out.println("-------MENU-------");
            System.out.println("Está ligado ? " + this.getLigado());
            System.out.println("Está tocando ? " + this.getTocando());
            System.out.print("Volume: " + this.getVolume());
            for (int i = 0; i <= this.getVolume(); i += 10) {
                System.out.print("|");
            }
        }
        System.out.println("");
    }

    @Override
    public void fecharMenu() {
        System.out.println("fechando o Menu!");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume() + 5);
        }
        else{
            System.out.println("Disponivel desligado!");
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume() - 5);
        }
        else{
            System.out.println("Disponivel desligado!");
        }
    }

    @Override
    public void ligarMundo() {
        if (this.getLigado() && this.getVolume() > 0){
            this.setVolume(0);
        }
    }

    @Override
    public void deligarMundo() {
        if (this.getLigado() && this.getVolume()  == 0)
            this.setVolume(50);
    }

    @Override
    public void play() {
        if (this.getLigado() &&! (this.getTocando())){
            this.setTocando(true);
        }
    }

    @Override
    public void pause() {
        if (this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }
    }
}
