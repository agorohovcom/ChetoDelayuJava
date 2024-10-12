package InnerClass;

public class StringSequence {
    private String[] strings;
    private int next = 0;

    public StringSequence(int size) {
        strings = new String[size];
    }

    public void add(String x) {
        if (next < strings.length) {
            strings[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == strings.length;
        }

        @Override
        public Object current() {
            return strings[i];
        }

        @Override
        public void next() {
            if (i < strings.length) {
                i++;
            }
        }

        public Selector selector() {
            return new SequenceSelector();
        }
    }
}
