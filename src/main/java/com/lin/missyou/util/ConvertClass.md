## 序列化和反序列的目标:
1. 工具类要满足强类型转换,不能将查询出字符串类型转化为Map和List这种弱类型(会失去强类型中定义的方法)
2. 工具类要能够正确将字符串正确转换为多体(List)和单体类型
3. 希望工具类具有泛用性(泛型),不对每一个业务对象都需要重写一个工具类