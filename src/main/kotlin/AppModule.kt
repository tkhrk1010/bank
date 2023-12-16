import `interface`.AccountInterface
import application.service.AccountUsecase
import domain.repository.AccountRepository
import infrastructure.repository.InMemoryAccountRepository
import org.koin.dsl.module

val appModule = module {
    single { InMemoryAccountRepository() }

    // register Implementation of AccountRepository
    single<AccountRepository> { InMemoryAccountRepository() }

    // get() automatically injects AccountRepository by Koin
    single { AccountUsecase(get()) }

    // get() automatically injects AccountUsecase by Koin
    single { AccountInterface(get()) }
}
