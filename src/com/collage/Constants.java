package com.collage;

public class Constants {

    public static enum UserType {
        ADMIN(0), USER(1);

        private int value;

        private UserType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static enum UserStatus {
        INACTIVE(0), ACTIVE(1);

        private int value;

        private UserStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
