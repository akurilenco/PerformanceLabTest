package utils;

/**
 * Так как неизвестно название сервиса, название абстрактно
 */
public class Builder {
    String endUrl = "";

    public TasksBuilder getTasks() {
        return new TasksBuilder();
    }

    public class TasksBuilder {
        public TasksBuilder() {
            endUrl += "/tasks";
        }

        public RestBuilder getRest() {
            return new RestBuilder();
        }

        public class RestBuilder {
            public RestBuilder() {
                endUrl += "/rest";
            }

            public RestBuilder getCreateUser() {
                endUrl += "/createuser";
                return this;
            }

            public String build() {
                return endUrl;
            }
        }
    }
}
