package com.assignment.question;

@WithBuilder
public class MessageBuilder {
    // step 1: declare the same set of attrs as there are in the Message class
    private MessageType messageType;
    private String content;
    private String sender;
    private String recipient;
    private boolean isDelivered;
    private long timestamp;

    // step 2: make the CTOR private
    private MessageBuilder(Builder builder) {
        this.messageType = builder.messageType;
        this.content = builder.content;
        this.sender = builder.sender;
        this.recipient = builder.recipient;
        this.isDelivered = builder.isDelivered;
        this.timestamp = builder.timestamp;
    }

    // step 3: make a static inner class Builder
    public static class Builder {
        private MessageType messageType;
        private String content;
        private String sender;
        private String recipient;
        private boolean isDelivered;
        private long timestamp;

        // step 4: make fluent interfaces to set the attrs - allows chaining
        public Builder messageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder recipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder isDelivered(boolean isDelivered) {
            this.isDelivered = isDelivered;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        // step 5: declare build()
        public MessageBuilder build() {
            return new MessageBuilder(this);
        }
    }
}