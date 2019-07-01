package collections;


public class ClassificationManager {

    private Object[] objects;
    private int numberOfObjects;
    
    public static final int DEFAULT_SIZE = 20;

    /**
     * Suporta a instanciação da classe tendo por base um valor por defeito para
     * o tamanho da coleção
     */
    public ClassificationManager() {
        objects = new Object[DEFAULT_SIZE];
        this.numberOfObjects = 0;
    }

    /**
     * Suporta a instanciação da classe tendo por base um valor definido para o
     * tamanho da coleção
     *
     * @param maxSize parametro que define o maximo da lista de Objetos
     */
    public ClassificationManager(int maxSize) {
        objects = new Object[maxSize];
        this.numberOfObjects = 0;
    }

    /**
     * Método responsável por inserir um objeto do vetor de objetos.
     *
     * @param o objeto a inserir no vetor
     * @return valor que sinaliza o sucesso/insucesso da operação
     */
    public boolean addObject(Object o) {
        if (numberOfObjects < objects.length) {
            objects[numberOfObjects++] = o;
            return true;
        } else {
            increaseSize();
            objects[numberOfObjects++] = o;
            return true;
        }

    }

    /**
     * Método responsável por remover um objeto do vetor de objetos.
     *
     * @param position indice correspondente ao elemento a eliminar
     * @return o objeto eliminado
     */
    public Object removeObject(int position) {
        if (position >= numberOfObjects) {
            return null;
        }

        Object rem = objects[position];

        for (int i = position; i < numberOfObjects; i++) {
            objects[i] = objects[i + 1];
        }

        return rem;
    }

    /**
     * Método responsavel por obter o tamanho da coleção
     *
     * @return tamanho da coleção
     */
    public int size() {
        return this.numberOfObjects;
    }

    /**
     * Método responsável por aumentar o tamanho da coleção
     */
    public void increaseSize() {
        Object[] newObjects = new Object[this.size() + 10];
        for (int i = 0; i < this.size(); i++) {
            newObjects[i] = objects[i];
        }

        objects = newObjects;
    }

    /**
     * Método responsável por diminuir o tamanho da coleção
     */
    public void decreaseSize() {
        numberOfObjects--;
    }

    /**
     * Método responsável por ordenar a coleção
     *
     */
   /* public void sort() {
        int n = objects.length;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (objects[i] instanceof Classification && objects[k] instanceof Classification && ((Classification) objects[i]).getBestLap() > ((Classification) objects[k]).getBestLap()) {
                    Classification temp;
                    temp = (Classification) objects[i];
                    objects[i] = objects[k];
                    objects[k] = temp;
                }
            }
        }
    }*/

    /**
     * Método responsável por retornar um objeto existente numa determinada
     * posição do vetor de objetos.
     *
     * @param i indice do elemento a devolver
     * @return objeto tipo object
     */
    public Object getObject(int i) {
        if (i < 0 || i >= numberOfObjects) {
            return null;
        }

        return this.objects[i];
    }

    /**
     * Método responsável por encontrar um objeto no vetor de objetos
     *
     * @param o objeto a procurar no vetor
     * @return o indice do objeto no vetor. no caso do elemento não existir,
     * retorna o valor -1
     */
    public int findObject(Object o) {
        for (int i = 0; i < numberOfObjects; i++) {
            if (objects[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }
}
