package it.tasgroup.xtderp.xtdplatform.admin.jwt;

import it.tasgroup.xtderp.xtdplatform.admin.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Simone Ricciardi (simone.ricciardi@gmail.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class XtdTokenEnhancer implements TokenEnhancer {

    private final Users users;

    @Override
    public OAuth2AccessToken enhance(final OAuth2AccessToken token, final OAuth2Authentication auth) {
        final Map<String,Object> info = new HashMap<>();
        info.put("displayName", this.users.byUserName(auth.getName()).displayName());
        final DefaultOAuth2AccessToken tok = new DefaultOAuth2AccessToken(token);
        tok.setAdditionalInformation(info);
        return tok;
    }
}
