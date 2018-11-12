并发容器和框架

HashMap : 线程不安全，在多线程环境下使用HashMap 进行put 操作会引起死循环

HashTable : 效率低下。 HashTable 容器使用synchronized 来保证线程安全，在线程竞争激烈的情况下HashTable 的效率非常低下

ConcurrentHashMap ： 是线程安全又高效的 HashMap ，concurrentHashMap 的使用锁的分段技术可有效提升并发访问率
    他是把数据分成一段一段地存储，然后给每一段数据配一把锁，当线程占用锁访问其中一个段数据的时候，其他段数据也能被其他线程访问

ConcurrentHashMap 的结构:
    ConcurrentHashMap 由 Segment 数组结构 和 HashEntry 数组结构组成
    |- Segment 是一种可重入锁（ReentrantLock），在ConcurrentHashMap 里扮演“锁” 的角色
    |- HashEntry 则用于存储键值对数据
    |- 一个Segment 里面包含一个 HashEntry 数组



