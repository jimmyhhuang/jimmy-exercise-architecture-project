package architecture.demo.entity.auth;


public class ArchitectureAuth {

	private static ThreadLocal authThreadLocal = new ThreadLocal();

	public static void setArchitectureRequestInfo(RequestBaseInfo requestbaseinfo) {
		authThreadLocal.set(requestbaseinfo);
	}

	public static RequestBaseInfo getArchitectureRequestInfo() {
        return (RequestBaseInfo)authThreadLocal.get();
	}

	public static void clearArchitectureRequestInfo() {
        authThreadLocal.remove();
	}
}
