// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chatroom.proto

public interface ChatMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ChatMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string user_id = 1;</code>
   * @return The userId.
   */
  java.lang.String getUserId();
  /**
   * <code>string user_id = 1;</code>
   * @return The bytes for userId.
   */
  com.google.protobuf.ByteString
      getUserIdBytes();

  /**
   * <code>string content = 2;</code>
   * @return The content.
   */
  java.lang.String getContent();
  /**
   * <code>string content = 2;</code>
   * @return The bytes for content.
   */
  com.google.protobuf.ByteString
      getContentBytes();

  /**
   * <code>string room_id = 3;</code>
   * @return The roomId.
   */
  java.lang.String getRoomId();
  /**
   * <code>string room_id = 3;</code>
   * @return The bytes for roomId.
   */
  com.google.protobuf.ByteString
      getRoomIdBytes();

  /**
   * <code>string message_id = 4;</code>
   * @return The messageId.
   */
  java.lang.String getMessageId();
  /**
   * <code>string message_id = 4;</code>
   * @return The bytes for messageId.
   */
  com.google.protobuf.ByteString
      getMessageIdBytes();

  /**
   * <code>.google.protobuf.Timestamp timestamp = 5;</code>
   * @return Whether the timestamp field is set.
   */
  boolean hasTimestamp();
  /**
   * <code>.google.protobuf.Timestamp timestamp = 5;</code>
   * @return The timestamp.
   */
  com.google.protobuf.Timestamp getTimestamp();
  /**
   * <code>.google.protobuf.Timestamp timestamp = 5;</code>
   */
  com.google.protobuf.TimestampOrBuilder getTimestampOrBuilder();
}