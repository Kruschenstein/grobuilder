package org.grorg.grobuilder;

public class GroDto {
    private long id;
    private String name;
    private int age;
    private double size;

    private GroDto(Builder builder) {
        id = builder.id;
        name = builder.name;
        age = builder.age;
        size = builder.size;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSize() {
        return size;
    }

    public static class Builder extends ConditionalBuilder<Builder, GroDto> {
        private long id;
        private String name;
        private int age;
        private double size;

        @Override
        protected Builder self() {
            return this;
        }

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder size(double size) {
            this.size = size;
            return this;
        }

        public GroDto build() {
            return new GroDto(this);
        }
    }

    @Override
    public String toString() {
        return "GroDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", size=" + size +
               '}';
    }
}
