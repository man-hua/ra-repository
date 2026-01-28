import com.common.Context
import com.service.AuthApiService

def res = Context.get(AuthApiService)
                 .login('eve.holt@reqres.in', 'cityslicka')

assert res.statusCode == 200

