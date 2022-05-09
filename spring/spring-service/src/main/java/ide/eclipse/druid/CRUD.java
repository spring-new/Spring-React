package ide.eclipse.druid;

public class CRUD {
    public class Student {
        private int id;
        private String name;
        private int age;
        private String qq;

        public Student(int id) {
            this.id = id;
        }

        public Student(String name, int age, String qq) {
            this.name = name;
            this.age = age;
            this.qq = qq;
        }

        public Student(int id, String name, int age, String qq) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.qq = qq;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", qq='" + qq + '\'' +
                    '}';
        }
    }


}
