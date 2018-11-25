
* scheduledThreadPoolExecutor

 1. public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);

 2. public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit);

 3. public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
 long initialDelay, long period, TimeUnit unit);

 4. public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command,
 long initialDelay, long delay, TimeUnit unit);

 1、 进行一次延迟调度：延迟delay这么长时间，单位为：TimeUnit传入的的一个基本单位，
 例如：TimeUnit.SECONDS属于提供好的枚举信息；（适合于方法1和方法2）。

 2、 多次调度，每次依照上一次预计调度时间进行调度，例如：延迟2s开始，5s一次，那么就是2、7、12、17，
 如果中间由于某种原因导致线程不够用，没有得到调度机会，那么接下来计算的时间会优先计算进去
 (就是说如果超过调度时间就等上一次结束之后就开始执行，不再等待)，
 因为他的排序会被排在前面，有点类似Timer中的：scheduleAtFixedRate方法，
 只是这里是多线程的，它的方法名也叫：scheduleAtFixedRate，所以这个是比较好记忆的（适合方法3）

 3、 多次调度，每次按照上一次实际执行的时间进行计算下一次时间，
 同上，如果在第7秒没有被得到调度，而是第9s才得到调度，那么计算下一次调度时间就不是12秒，而是9+5=14s，
 如果再次延迟，就会延迟一个周期以上，也就会出现少调用的情况（适合于方法4）；