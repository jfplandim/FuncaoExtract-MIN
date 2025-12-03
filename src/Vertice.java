public class Vertice {
    private String id;
    private int chave;
    private String pai;

    public Vertice(String id, int chave) {
        this.id = id;
        this.chave = chave;
        this.pai = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }
}
