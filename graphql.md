Schema:
A GraphQL schema is at the center of any GraphQL server implementation and describes the functionality available to the clients which connect to it.

Query:
A GraphQL query is the client application request to retrieve data from database or legacy API's.

Resolver
Resolvers provide the instructions for turning a GraphQL operation into data. They resolve the query to data by defining resolver functions.

Type System defines various data types that can be used in a GraphQL application. The type system helps to define the schema, which is a contract between client and server.

Scalar
Stores a single value


Object

Shows what kind of object can be fetched

Query

Entry point type to other specific types

Mutation

Entry point for data manipulation

Enum

Useful in a situation where you need the user to pick from a prescribed list of options


Mutation Type
Mutations are operations sent to the server to create, update or delete data. These are analogous to the PUT, POST,
PATCH and DELETE verbs to call REST-based APIs.


Mutation is one of the root-level data-types in GraphQL. The Query type defines the entry-points for data-fetching operations whereas
the Mutation type specifies the entry points for data-manipulation operations.


Non-Nullable Type:
field:data_type!


type Student {
   stud_id:ID!.

   firstName:String
   lastName:String
   fullName:String
   college:College
}

Qury:
 GraphQL query is used to fetch data. It is like requesting a resource in REST-based APIs. To keep it simple, the Query type is the request sent
  from a client application to the GraphQL server. GraphQL uses the Schema Definition Language (SDL)

 Resolver is a collection of functions that generate response
  for a GraphQL query. In simple terms, a resolver acts as a GraphQL query handler

  scalar or object

  a resolver can also return other values