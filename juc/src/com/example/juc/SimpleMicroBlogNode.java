package com.example.juc;

/**
 * User: guorui
 * Date: 13-8-30
 * Time: 下午3:40
 */
public interface SimpleMicroBlogNode {

    void propagateUpdate(Update upd_, SimpleMicroBlogNode backup_);

    void confirmUpdate(SimpleMicroBlogNode other_, Update update_);

    String getIdent();

}
