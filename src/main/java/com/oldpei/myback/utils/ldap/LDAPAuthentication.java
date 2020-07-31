//package com.oldpei.myback.utils.ldap;
//
//import java.util.Hashtable;
//
//import javax.naming.Context;
//import javax.naming.NamingEnumeration;
//import javax.naming.NamingException;
//import javax.naming.directory.SearchControls;
//import javax.naming.directory.SearchResult;
//import javax.naming.ldap.InitialLdapContext;
//import javax.naming.ldap.LdapContext;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * LDAPAuthentication class.
// *
// * @author jixing.pei
// * @version 1.0
// */
//@Component
////@RefreshScope
//public class LDAPAuthentication {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(LDAPAuthentication.class);
//
//	@Value("${sbibits.ldap.url}")
//    private String url;
//
//	@Value("${sbibits.ldap.domain}")
//    private String domain;
//
//	@Value("${sbibits.ldap.rootdn}")
//    private String rootdn;
//
//	public boolean login(String userId, String password) {
//		if (password == null || password.isEmpty()) {
//			return false;
//		}
//		boolean ret = false;
//		String userDn = "";
//		LdapContext ctx = null;
//		try {
//			LOGGER.info("createCTX start");
//			ctx = createCTX(userId, password);
//			LOGGER.info("createCTX success");
//
//			LOGGER.info("getUserDN start");
//			userDn = getUserDN(ctx, userId, password);
//			LOGGER.info("getUserDN success");
//
//		} catch (Exception e) {
//			LOGGER.info("LDAPAuthentication search user dn failed.");
//			LOGGER.info("", e);
//			ret = false;
//			return ret;
//		}
//		if (ctx != null) {
//			try {
//
//				LOGGER.info("connect start");
//				connect(ctx, userDn, password);
//				LOGGER.info("connect success");
//			} catch (Exception e) {
//				LOGGER.info("connect failed");
//				LOGGER.info("LDAPAuthentication" + userId + " is not authenticated.");
//				LOGGER.info("", e);
//				ret = false;
//				return ret;
//			} finally {
//
//				try {
//					ctx.close();
//				} catch (Exception e) {
//					LOGGER.info("ctx.close failed");
//					LOGGER.info("", e);
//				}
//
//			}
//
//			ret = true;
//			LOGGER.info("LDAPAuthentication" + userId + " is authenticated.");
//		}
//
//		return ret;
//	}
//
//	public LdapContext createCTX(String userId, String password) throws Exception {
//		Hashtable<String, String> env = new Hashtable<String, String>();
//		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//		env.put(Context.PROVIDER_URL, url);
//		env.put(Context.SECURITY_AUTHENTICATION, "simple");
//		env.put(Context.SECURITY_PRINCIPAL, userId + "@" + domain);
//		env.put(Context.SECURITY_CREDENTIALS, password);
//
//		return new InitialLdapContext(env, null);
//	}
//
//	public String getUserDN(LdapContext ctx, String userId, String password) throws Exception {
//		String userDN = null;
//
//		SearchControls searchCtls = new SearchControls();
//		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
//
//		String searchFilter = "(&(ObjectClass=*)(sAMAccountName=" + userId + "))";
//
//		NamingEnumeration<SearchResult> answer = null;
//			LOGGER.info("ctx.search start");
//			answer = ctx.search(rootdn, searchFilter, searchCtls);
//			LOGGER.info("ctx.search end");
//			if (answer != null) {
//				while (answer.hasMoreElements()) {
//					SearchResult sr = (SearchResult) answer.next();
//
//					userDN = "";
//					userDN += sr.getName();
//					userDN += "," + rootdn;
//				}
//			} else {
//
//				LOGGER.info("answer is null");
//			}
//
//
//		return userDN;
//	}
//
//	private void connect(LdapContext ctx, String userDn, String password) throws NamingException {
//		ctx.addToEnvironment(Context.SECURITY_PRINCIPAL, userDn);
//		ctx.addToEnvironment(Context.SECURITY_CREDENTIALS, password);
//		ctx.reconnect(null);
//
//	}
//}
