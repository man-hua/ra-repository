import com.common.Context
import com.service.GuruApiService

def res = Context.get(GuruApiService)
                .listAPI('user', 'pass')

assert res.statusCode == 200
